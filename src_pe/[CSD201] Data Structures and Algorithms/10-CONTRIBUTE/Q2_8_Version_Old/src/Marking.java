// ======= DO NOT EDIT THIS FILE ============
import java.util.*;
import java.io.*;
class Foo
 {String [] u;int max, n;
  Foo(String [] v, int m) 
   {max = 100; u = new String[max];
    u = new String[max];
    int i;
    if(m <= v.length)
      n = m;
       else
       n = v.length;
    for(i=0;i<n;i++) u[i] = v[i];
   }
  void trim() 
   {for(int i=0;i<n;i++) 
      if(u[i]!=null) u[i]=u[i].trim();
   }
  boolean equal(Foo y)
   {if(n != y.n) return(false);
    trim(); y.trim();
    for(int i=0;i<n;i++)
     if(!u[i].equals(y.u[i])) return(false);
    return(true); 
   }
 }
class Marking 
 {static int nOuFi;// Number of files containing output  
  double [] mark;  
  Marking(int k) 
   {nOuFi=k; mark = new double[nOuFi+1];
    for(int i = 1; i<= nOuFi; i++) mark[i] = 1.0;
    if(nOuFi==4) mark[3] = mark[4] = 1.5;
   }

  Foo [] loadFile(String fname) throws Exception
   {Foo [] a = new Foo[100]; int i,j,m,r;
    RandomAccessFile f;
    String s; String [] p = new String[50];
    StringTokenizer t;
    f = new RandomAccessFile(fname, "r");
    i=0;
    while(true)
        {s = f.readLine();
         if(s==null) break;
         s = s.trim();
         if(s.length()==0) continue;
         t = new StringTokenizer(s," ");
         String x;
         j=0;
         while(t.hasMoreTokens())  
          {x = t.nextToken();
           x.trim();
           if(isNumber(x) && x.indexOf(".")>0)    
            {r = x.indexOf(".");
             if(x.length() > r + 3) x = x.substring(0,r+3);//Neu x la so thuc thi chi lay 2 chu so le
            }
           p[j++] = x;
          }
         a[i++] = new Foo(p,j);
        }
      f.close();
      m = i;
      Foo [] b = new Foo[m];
      for(i=0;i<m;i++) b[i] = a[i];
      return(b);
   }

  boolean isNumber(String u)
   {u = u.trim();double x;
    try {
      x = Double.parseDouble(u);
     }
     catch(Exception e) {return(false);}
    return(true);
   }

  boolean exist(String fname) throws Exception
    {File g = new File(fname);
     if(g.exists()) return(true); else return(false);
    }

  boolean isEqual(String fname1, String fname2) throws Exception
    {if(!exist(fname1) || !exist(fname2)) return(false);
     int n,i;
     Foo [] a = loadFile(fname1);
     Foo [] b = loadFile(fname2);
     if(a.length != b.length) return(false);
     n = a.length;
     for(i=0;i<n;i++)
       {if(!a[i].equal(b[i])) return(false);
       }
     return(true);
    }

  boolean checkResultFile() throws Exception
   {String fname;int i;
    for(i=1;i<=nOuFi;i++)
     {fname = "R_f" + i + ".txt";
      if(!exist(fname)) return(false); 
     }
    return(true);
   }

  void marking() throws Exception
   {if(!checkResultFile())
      {System.out.println(" This option cannot be done because correct-output files are missing!");
       return;
      }
    String fname = new String("result.txt");
    File g = new File(fname);
    if(g.exists()) g.delete();
    RandomAccessFile f;
    f = new RandomAccessFile(fname, "rw");
    int i; double mar,sum;
    String fname1, fname2;
    sum = 0;
    for(i=1;i<=nOuFi;i++)
     {fname1 = "f" + i + ".txt";
      fname2 = "R_f" + i + ".txt";
      if(!exist(fname1) || !isEqual(fname1,fname2)) mar=0; else mar = mark[i];
      sum += mar;
      f.writeBytes("  " + "f" + i + " : " + mar + " mark" + "\r\n");
     }
    f.writeBytes("  Total marks: " + sum + "\r\n");
    f.close();
    Lib.viewFile(fname);
   }
 }