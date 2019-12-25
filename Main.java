import java.util.Scanner;
public class Main
{ 
    static int x1, x, y1,xsum, y,y2,c1, c2, x2,sum,eec;
    static Scanner yo;
    public static void linear(){
        int rsum=0;
        int lsum=0;
        yo=new Scanner(System.in);
        System.out.println("Enter your linear equation in any format (but writing 'x' as '1x'):");
        System.out.println();
        String t=yo.nextLine();
        t=t.replace(" ","")+" ";
        char[]a=t.toCharArray();
        int n=a.length;
        int h=0;
        eec=0;
        while (h<n){
            if(a[h]=='='){
                eec=h;
                break;
            }
            h++;
        }
        int b=0;
        while(b<eec){
            String temp="";
            while (b<eec){
                if(a[b+1]=='x'){
                    temp="0";
                    b+=2;
                    break;
                }
                else if(a[b]=='-'){
                    lsum+=Integer.parseInt(temp);
                    temp="-";
                }
                else if(a[b]=='+'&&temp.length()>0){
                    lsum+=Integer.parseInt(temp);
                    temp="+";
                } 
                else
                    temp+=a[b];
                b++;
            }
            lsum+=Integer.parseInt(temp);
        }
        b=eec+1;
        while(b<n-1){
            String temp="";
            while (b<n-1){
                if(a[b+1]=='x'){
                    temp="0";
                    b+=2;
                    break;
                }
                else if(a[b]=='-'){
                    if(temp.length()>0&&b!=eec+1)
                        rsum+=Integer.parseInt(temp);
                    temp="-";
                }
                else if(a[b]=='+'){
                    if(b!=eec+1&&temp.length()>0)
                        rsum+=Integer.parseInt(temp);
                    temp="+";
                }
                else if(a[b]!=' ')
                    temp+=a[b];
                b++;
            }
            rsum+=Integer.parseInt(temp);
        }
        sum=rsum-lsum;
        b=0;
        System.out.println();
        rsum=0;
        lsum=0;
        while(b<eec){
            String temp="";
            while (b<eec){
                if(a[b+1]=='x'){
                    temp+=a[b];
                    lsum+=Integer.parseInt(temp);
                    b+=2;
                    break;
                }
                else if(a[b]=='-')
                    temp="-";
                else if(a[b]=='+')
                    temp="+";
                else
                    temp+=a[b];
                b++;
            }
        }
        b=eec+1;
        while(b<n-1){
            String temp="";
            while (b<n-1){
                if(a[b+1]=='x'){
                    temp+=a[b];
                    rsum+=Integer.parseInt(temp);
                    b+=2;
                    break;
                }
                else if(a[b]=='-')
                    temp="-";
                else if(a[b]=='+')
                    temp="+";
                else if(a[b]!=' ')
                    temp+=a[b];
                b++;
            }
        }
        xsum=lsum-rsum;
        System.out.println("Your Answer Is "+(double)sum/xsum);
        System.out.println();
        linear();
    }

    public static void simul(){
        yo=new Scanner(System.in);
        System.out.println("Enter your simultaneous equations in any format (but writing 'x' as '1x'):");
        System.out.println();
        String t=yo.nextLine();
        String p=yo.nextLine();
        t=t.replace(" ", "")+" ";
        p=p.replace(" ", "")+" ";
        int lx1=0;
        int ly1=0;
        int rx1=0;
        int ry1=0;
        int a=0;
        eec=t.indexOf("=");
        String temp="";
        while (a<eec){
            if(t.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(t.charAt(a)=='y'){
                temp="";
                a++;
                continue;
            }
            else if (t.charAt(a)!='-'&&t.charAt(a)!='+')
                temp+=t.charAt(a);
            if(t.charAt(a+1)=='x'){
                lx1+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=0;
        temp="";
        while (a<eec){
            if(t.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(t.charAt(a)=='x'){
                temp="";
                a++;
                continue;
            }
            else if (t.charAt(a)!='-'&&t.charAt(a)!='+')
                temp+=t.charAt(a);
            if(t.charAt(a)=='+'){
                temp="";
                a++;
                continue;
            }
            if(t.charAt(a+1)=='y'){
                ly1+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=eec+1;
        temp="";
        while (a<t.length()-1){
            if(t.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(t.charAt(a)=='y'){
                temp="";
                a++;
                continue;
            }
            else if (t.charAt(a)!='-'&&t.charAt(a)!='+')
                temp+=t.charAt(a);
            if(t.charAt(a+1)=='x'){
                rx1+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=eec+1;
        temp="";
        while (a<t.length()-1){
            if(t.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(t.charAt(a)=='x'){
                temp="";
                a++;
                continue;
            }
            if (t.charAt(a)!='+'&&t.charAt(a)!='y')
                temp+=t.charAt(a);
            if(t.charAt(a+1)=='y'){
                ry1+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=0;
        int lc1=0;
        int rc1=0;
        temp="";
        while (a<eec){
            if(t.charAt(a)=='-'){
                if(temp.length()>0)
                    lc1+=Integer.parseInt(temp);
                temp="-";
                a++;
                continue;
            }
            if(t.charAt(a+1)=='x'||t.charAt(a+1)=='y'){
                temp="";
                a+=2;
                continue;
            }
            if(t.charAt(a)!='+'){
                temp+=t.charAt(a);
                a++;
            }
            if(t.charAt(a)=='+'){
                if(temp.length()>0)
                    lc1+=Integer.parseInt(temp);
                temp="";
                a++;
            }
        }
        if(temp.length()>0)
            lc1+=Integer.parseInt(temp);a=eec+1;
        temp="";
        while (a<t.length()-1){
            if(t.charAt(a)=='-'){
                if(temp.length()>0)
                    rc1+=Integer.parseInt(temp);
                temp="-";
                a++;
                continue;
            }
            if(t.charAt(a+1)=='x'||t.charAt(a+1)=='y'){
                temp="";
                a+=2;
                continue;
            }
            if(t.charAt(a)!='+'){
                temp+=t.charAt(a);
                a++;
            }
            if(t.charAt(a)=='+'){
                if(temp.length()>0)
                    rc1+=Integer.parseInt(temp);
                temp="";
                a++;
            }
        }
        if(temp.length()>0)
            rc1+=Integer.parseInt(temp);
        int lx2=0;
        int ly2=0;
        int rx2=0;
        int ry2=0;
        a=0;
        eec=p.indexOf("=");
        temp="";
        while (a<eec){
            if(p.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(p.charAt(a)=='y'){
                temp="";
                a++;
                continue;
            }
            else if (p.charAt(a)!='-'&&p.charAt(a)!='+')
                temp+=p.charAt(a);
            if(p.charAt(a+1)=='x'){
                lx2+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=0;
        temp="";
        while (a<eec){
            if(p.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(p.charAt(a)=='x'){
                temp="";
                a++;
                continue;
            }
            else if (p.charAt(a)!='-'&&p.charAt(a)!='+')
                temp+=p.charAt(a);
            if(p.charAt(a)=='+'){
                temp="";
                a++;
                continue;
            }
            if(p.charAt(a+1)=='y'){
                ly2+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=eec+1;
        temp="";
        while (a<p.length()-1){
            if(p.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(p.charAt(a)=='y'){
                temp="";
                a++;
                continue;
            }
            else if (p.charAt(a)!='-'&&p.charAt(a)!='+')
                temp+=p.charAt(a);
            if(p.charAt(a+1)=='x'){
                rx2+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=eec+1;
        temp="";
        while (a<p.length()-1){
            if(p.charAt(a)=='-'){
                temp="-";
                a++;
                continue;
            }
            if(p.charAt(a)=='x'){
                temp="";
                a++;
                continue;
            }
            if (p.charAt(a)!='+'&&p.charAt(a)!='y')
                temp+=p.charAt(a);
            if(p.charAt(a+1)=='y'){
                ry2+=Integer.parseInt(temp);
                temp="";
                a+=2;
                continue;
            }
            a++;
        }
        a=0;
        int lc2=0;
        int rc2=0;
        temp="";
        while (a<eec){
            if(p.charAt(a)=='-'){
                if(temp.length()>0)
                    lc2+=Integer.parseInt(temp);
                temp="-";
                a++;
                continue;
            }
            if(p.charAt(a+1)=='x'||p.charAt(a+1)=='y'){
                temp="";
                a+=2;
                continue;
            }
            if(p.charAt(a)!='+'){
                temp+=p.charAt(a);
                a++;
            }
            if(p.charAt(a)=='+'){
                if(temp.length()>0)
                    lc2+=Integer.parseInt(temp);
                temp="";
                a++;
            }
        }
        if(temp.length()>0)
            lc2+=Integer.parseInt(temp);
        a=eec+1;
        temp="";
        while (a<p.length()-1){
            if(p.charAt(a)=='-'){
                if(temp.length()>0)
                    rc2+=Integer.parseInt(temp);
                temp="-";
                a++;
                continue;
            }
            if(p.charAt(a+1)=='x'||p.charAt(a+1)=='y'){
                temp="";
                a+=2;
                continue;
            }
            if(p.charAt(a)!='+'){
                temp+=p.charAt(a);
                a++;
            }
            if(p.charAt(a)=='+'){
                if(temp.length()>0)
                    rc2+=Integer.parseInt(temp);
                temp="";
                a++;
            }
        }
        if(temp.length()>0)
            rc2+=Integer.parseInt(temp);
        x1=lx1-rx1;
        x2=lx2-rx2;
        y1=ly1-ry1;
        y2=ly2-ry2;
        c1=rc1-lc1;
        c2=rc2-lc2;
        double y=(double)(c1*x2-c2*x1)/(double)(((y1*x2)-(y2*x1)));
        double x=(double)(-1*y2*y+c2)/(double)x2;
        System.out.println();
        if((int)x==x)
            System.out.println("x is "+(int)x);
        else
            System.out.println("x is "+x);
        if((int)y==y)
            System.out.println("y is "+(int)y);
        else
            System.out.println("y is "+y);
        System.out.println();
        simul();
    }

    public static void quad(){
        yo=new Scanner(System.in);
        System.out.println("Enter your equation in any format (but writing 'x' as '1x'):");
        System.out.println();   
        String t=yo.nextLine();
        t=t.replace(" ", "");
        int eec=t.indexOf("=");
        int a=0;
        int lsq=0;                    
        int lx=0;
        int rsq=0;
        int lc=0;
        int rc=0;
        int rx=0;
        String temp="";                       
        while (a<eec){
            if(t.charAt(a)=='-'){
                if(temp.length()>0)
                    lc+=Integer.parseInt(temp);
                temp="-";
                a++;
                continue;                             
            }
            if(t.substring(a, a+3).equals("x^2")){
                lsq+=Integer.parseInt(temp);
                temp="";
                a+=3;
                continue;
            }
            if(t.charAt(a)=='x'){
                lx+=Integer.parseInt(temp);
                temp="";
                a++;
                continue;
            }
            if(t.charAt(a)=='+'){
                if(temp.length()>0){
                    lc+=Integer.parseInt(temp);
                    temp="";
                }
                a++;
                continue;
            }
            temp+=t.charAt(a);
            a++;
        }
        if(temp.length()>0)
            lc+=Integer.parseInt(temp);
        temp="";
        a=eec+1;
        while (a<t.length()){
            if(t.charAt(a)=='-'){
                if(temp.length()>0)
                    rc+=Integer.parseInt(temp);
                temp="-";
                a++;
                continue;
            }
            if(a+3<=t.length())
                if(t.substring(a, a+3).equals("x^2")){
                    rsq+=Integer.parseInt(temp);
                    temp="";
                    a+=3;
                    continue;
                }
            if(t.charAt(a)=='x'){
                rx+=Integer.parseInt(temp);
                temp="";
                a++;
                continue;
            }
            if(t.charAt(a)=='+'){
                if(temp.length()>0){
                    rc+=Integer.parseInt(temp);
                    temp="";
                }
                a++;
                continue;
            }
            temp+=t.charAt(a);
            a++;
        }
        if(temp.length()>0)
            rc+=Integer.parseInt(temp);
        int b=lx-rx;
        int d=lsq-rsq;
        int c=lc-rc;
        double a1=(-b+(Math.sqrt(b*b-4*d*c)))/(2*d);
        double a2=(-b-(Math.sqrt(b*b-4*d*c)))/(2*d);
        System.out.println();
        if(a1==(int)a1)
            System.out.println("Your first solution is "+(int)a1);  
        else
            System.out.println("Your first solution is "+a1);
        if(a2==(int)a2)
            System.out.println("Your second solution is "+(int)a2);
        else
            System.out.println("Your second solution is "+a2);
        System.out.println();   
        quad();
    }

    public static void main(String[]args){
        yo=new Scanner(System.in);
        System.out.println("WELCOME TO ERRY'S EQUATION SOLVER!\n");
        System.out.println("Please note that the linear and quadratic solvers will use variable\n'x' while the simultaneous solver will use variables 'x' and 'y'.\n");
        System.out.println("Which equation would you wish to solve?\n1. Linear\n2. Simultaneous\n3. Quadratic");
        int chois=yo.nextInt();
        switch(chois){
            case 1:
            linear();
            break;
            case 2:
            simul();
            break;
            case 3:
            quad();
        }
    }
}
