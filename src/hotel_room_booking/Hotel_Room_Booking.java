package hotel_room_booking;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel_Room_Booking {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------------");
        System.out.println("------ Welcome to FedUni Hotel Bookings -------");
        System.out.println("-----------------------------------------------");
        boolean flag=true;
        int counter;
        ArrayList<String> nameList=new ArrayList<>();
        ArrayList<Integer> roomNo=new ArrayList<>();
        ArrayList<Integer> roomCapacity=new ArrayList<>();
        while(flag)
        {
        System.out.println("Main Menu - please select an option:");
        System.out.println("1.) Add guest");
        System.out.println("2.) Add room ");
        System.out.println("3.) Add booking");
        System.out.println("4.) View bookings ");
        System.out.println("5.) Quit ");
        Scanner input=new Scanner(System.in);
        int number=input.nextInt();
        
        switch(number)
        {
            case 1:
                System.out.println("Please enter guest name: ");
                Scanner value = new Scanner(System.in);
                String name=value.nextLine();
                nameList.add(name);
                counter=nameList.size();
                System.out.println("Guest "+name+" has been created with guest ID: "+counter+" Would you like to [A]dd a new guest or [R]eturn to the previous menu?");                
                boolean flag1=true;
                while(flag1)
                {
                    String enn=value.nextLine();
                    if(enn.equals("A"))
                    {
                        System.out.println("Please enter guest name: ");
                        String manyName=value.nextLine();
                        nameList.add(manyName);
                        counter=nameList.size();
                        System.out.println("Guest "+manyName+" has been created with guest ID: "+counter+" Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
                        flag=false;
                    }
                    else if(enn.equals("R"))
                    {
                        flag1=false;
                        flag=true;
                    }
                    else
                    {
                        System.out.println("Invalid Input");
                        System.out.println("Would you like to [A]dd a new guest or [R]eturn to the previous menu?");
                        flag=false;
                    }
                }
                break;
            case 2:
                int rNo,rCap;
                boolean flg=true;
                while(flg)
                {
                    try
                    {
                    System.out.println("Please enter room number: ");
                    Scanner enter=new Scanner(System.in);
                    rNo=enter.nextInt();
                    System.out.println("Please enter room capacity: ");
                    rCap=enter.nextInt();
                    roomNo.add(rNo);
                    roomCapacity.add(rCap);
                    System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
                    boolean flag2=true;
                    while(flag2)
                    {
                        Scanner entere=new Scanner(System.in);
                        String validate=entere.nextLine();
                        if(validate.equals("A"))
                        {
                            System.out.println("Please enter room number: ");
                            rNo=enter.nextInt();
                            boolean ex=false;
                            for(Integer s:roomNo)
                            {
                                if(roomNo.contains(rNo))
                                {
                                    ex=true;
                                    break;
                                }
                            }
                            if(ex==true)
                            {
                                System.out.println("ALready Exist");
                                System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
                            }
                            else
                            {
                                roomNo.add(rNo);
                                System.out.println("Please enter room capacityy: ");
                                rCap=enter.nextInt();
                                roomCapacity.add(rCap);
                                System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
                                flag=false;
                            }
                        }
                        else if(validate.equals("R"))
                        {
                            flag2=false;
                            flg=false;
                            flag=true;
                        }
                        else
                        {
                            System.out.println("Invalid Input");
                            System.out.println("Would you like to [A]dd a new room or [R]eturn to the previous menu?");
                            flag=false;
                        }
                    }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Please Enter valid Number: ");
                        flg=true;
                    }
                }
                break;
            case 3:
                try
                {
                PrintWriter fw=new PrintWriter("sad.txt");
                boolean exist=true;
                while(exist)
                {
                try
                {
                    System.out.println("Please enter guest ID: ");
                    Scanner id=new Scanner(System.in);
                    int guestId=id.nextInt();
                    for(int i=1;i<=nameList.size();i++)
                    {
                        if(i==guestId)
                        {
                            fw.println("Guest Name: "+nameList.get(i-1));
                            exist=false;
                            break;
                        }
                        else if(guestId>nameList.size())
                        {
                            System.out.println("Guest does not exist.");
                            exist=true;
                        }
                    }
                    }
                    catch(Exception e)
                    {
                        System.out.println("Invalid Input!");
                    }
                }
                
                int num=0,index=0;
                boolean t=false;
                boolean check=true;
                while(check)
                {
                try
                {
                    System.out.println("Please enter room number:");
                    Scanner id=new Scanner(System.in);
                    int room=id.nextInt();
                    for(int i=1;i<=roomNo.size();i++)
                    {
                        if(roomNo.get(i-1).equals(room))
                        {
                            fw.print("Booking : Room "+room);
                            System.out.println("Please enter number of guests: ");
                            num=roomCapacity.get(i-1);
                            t=true;
                            index=i-1;
                            break;
                        }
                    }
                }
                catch(Exception e)
                {
                    System.out.println("Invalid input!");
                }
                
                Scanner ii=new Scanner(System.in);
                int inMonth=33;
                int inDay;
                int get=ii.nextInt();
                    if(t=true && roomCapacity.get(index)>get || roomCapacity.get(index)<get)
                    {
                        System.out.println("Guest count exceeds room capacity of: "+roomCapacity.get(index));
                        check=true;
                    }
                    else
                    {
                        fw.print(", "+num+" guests from ");
                        Scanner n=new Scanner(System.in);
                        boolean mn=true;
                        System.out.println("Please enter check-in month: ");
                        while(mn)
                        {
                            inMonth=n.nextInt();
                            if(inMonth>12 || inMonth<1)
                            {
                                System.out.println("Invalid month. Please enter check-in month: ");
                                mn=true;
                            }
                            else
                            {
                                mn=false;
                            }
                        }
                        boolean dy=true;
                        System.out.println("Please enter check-in day: ");
                        while(dy)
                        {
                            inDay=n.nextInt();
                            if(inDay<1 || inDay>31)
                            {
                                System.out.println("Invalid day. Please enter check-in day: ");
                                dy=true;
                            }
                            else
                            {
                                fw.print(inMonth+"/"+ inDay);
                                dy=false;
                            }
                        }
                        boolean on=true;
                        int outMonth=33;
                        System.out.println("Please enter check-out month: ");
                        while(on)
                        {
                            outMonth=n.nextInt();
                            if(outMonth>12 || outMonth<1)
                            {
                                System.out.println("Invalid month. Please enter check-out month: ");
                                on=true;
                            }
                            else
                            {
                                on=false;
                            }
                        }
                        boolean oy=true;
                        int outDay=33;
                        System.out.println("Please enter check-out day: ");
                        while(oy)
                        {
                            outDay=n.nextInt();
                            if(outDay<1 || outDay>31)
                            {
                                System.out.println("Invalid day. Please enter check-out day: ");
                                oy=true;
                            }
                            else
                            {
                                oy=false;
                            }
                        }
                        fw.println(" to "+outMonth+"/"+outDay);
                        check=false;
                    }
                }
                fw.close();
                }
                catch(Exception e)
                {
                    System.out.println("Does not found");
                }
                flag=false;
                System.out.println("*** Booking successful! ***");
                break;
            case 4:
                System.out.println("Would you like to view [G]uest bookings, [R]oom booking, or e[X]it?");
                try
                {
                    FileReader freader = new FileReader("sad.txt");
                    BufferedReader br = new BufferedReader(freader);
                    String s;
                    while((s = br.readLine()) != null) 
                    {
                        System.out.println(s);
                    }
                    freader.close();
                }
                catch(Exception e)
                {
                    System.out.println("No data found");
                }
                flag=false;
                break;
            case 5:
                System.out.println("Thanks for using FedUni Hotel Bookings!");
                flag=false;
                break;
            default:
                flag=false;
                System.out.println("Invalid Input");   
            }
        }   
    }
    int dateToDayNumber(int month, int day) 
    {
        // Catch invalid input and return early
        if(month < 1 || month > 12 || day < 1 || day > 31) return 0; 
        if(month == 1 ) return day;
        if(month == 2 ) return 31 + day; 
        if(month == 3 ) return 59 + day; 
        if(month == 4 ) return 90 + day; 
        if(month == 5 ) return 120 + day;
        if(month == 6 ) return 151 + day; 
        if(month == 7 ) return 181 + day; 
        if(month == 8 ) return 212 + day; 
        if(month == 9 ) return 243 + day; 
        if(month == 10) return 273 + day; 
        if(month == 11) return 304 + day;
        return 334 + day;
    } 
    int dayNumberToMonth(int dayNumber) 
    { 
        // Catchinvalid input and return early 
        if (dayNumber < 1|| dayNumber > 365) return 0;
        if (dayNumber <= 31 ) return 1; // Jan
        if (dayNumber <= 59 ) return 2; // Feb
        if (dayNumber <= 90 ) return 3; // Mar
        if (dayNumber <= 120) return 4; // Apr
        if (dayNumber <= 151) return 5; // May
        if (dayNumber <= 181) return 6; // Jun
        if (dayNumber <= 212) return 7; // Jul
        if (dayNumber <= 243) return 8; // Aug
        if (dayNumber <= 273) return 9; // Sep
        if (dayNumber <= 304) return 10; // Oct
        if (dayNumber <= 334) return 11; // Nov
        return 12; // Dec
    }
    int dayNumberToDayOfMonth(int dayNumber) 
    { 
        //Catch invalid input and return early 
        if (dayNumber< 1 || dayNumber > 365) return 0;
        if (dayNumber <= 31 ) return dayNumber; // Jan
        if (dayNumber <= 59 ) return dayNumber - 31; // Feb 
        if(dayNumber <= 90 ) return dayNumber - 59; // Mar 
        if(dayNumber <= 120) return dayNumber - 90; // Apr 
        if(dayNumber <= 151) return dayNumber - 120; // May 
        if(dayNumber <= 181) return dayNumber - 151; // Jun 
        if(dayNumber <= 212) return dayNumber - 181; // Jul 
        if(dayNumber <= 243) return dayNumber - 212; // Aug 
        if(dayNumber <= 273) return dayNumber - 243; // Sep 
        if(dayNumber <= 304) return dayNumber - 273; // Oct 
        if(dayNumber <= 334) return dayNumber - 304; // Nov
        return dayNumber - 334; // Dec
    }
}