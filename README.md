# FMS-system-AP-project
This is a repository for our AP project based on designing a FMS system.
    Contributors: Rupal Jain and Gargi Gupta
    Following is the description of what and how we plan to go about it.

    Use Cases:
    1. User choice
    2. GM Check
    3. Login
    4. Registration
    5. Add
    6. Delete by GM
    7. View by GM
    8. Check
    9. Approve
    10. Assign
    11. Add by supervisor
    12. View by supervisor
    13. Delete by supervisor
    14. Logistics
    15. New logistics
    16. Update status
    17. Leave by staff
    18. Task report
    19. View task
    20. Assign by supervisor
    21. Supervisor check
    22. Logout
    23. Leave by supervisor

Design analysis of the project (Brief description of our FMS system and it’s use cases):

1. Due to obvious reasons, we have considered that GM/admin already exist because without
them the system can’t exist. So to initiate the system, admin needs to be present at the least.

2. In the diagram we have taken admin(already existing), supervisor and staff. And rest is the
system having various use cases(i.e. the specific functionalities). And they can balog to any of
the 5 departments.

3. At the very first step, user is asked to enter his choice(as to which department he belong/will
belong to.

4. Then as per the department he chooses, he is again prompted to enter another choice for sign
up/login.

5. Sign-up  In this case, admin puts a check whether he allows the user to be added to the
system or not. If yes, he is be added to the respective database(based on the department), else
rejected and returns back to the user choice page.
Login  In this case, the functionalities’ channel for him opens(based on his post and
department).

6. ADMIN  he can perform various functionalities(use cases) like:
1. Delete: he can delete a staff member/supervisor. Then it is being removed from Database.
2. View: Same as above.
3. Assign: He can assign a particular task to any staff member or supervisor. This will be taken an input string and added to the database.
4. Approve/reject: He holds the right to approve/reject any kind of request from supervisor or staff member.

7. SUPERVISOR  he can perform various functionalities(use cases) like:
1. Add: he can add the staff member. If so, his entry will be added to the database.
2. Delete: same as above
3. View: he can choose to view the details/working of his staff member and give his feedback to the staff members.(this feedback use case will be extended from the View use case since this is completely optional for the supervisor.
4. Assign: Can assign task to the staff members and the details of the task will be accordingly added to the database of the staff.
5. ViewTask: To keep a check on the status of the task.
6. Logistics: To keep a check on whether everything in his department is going properly or not and in case he feels the need of any kind of amendment, he requests the admin for the new logistics  this will be an extended use case since it solely depends on the supervisor whether he wants to make any changes/modifications in the working of the staff.
7. Leave: can apply for leave to the admin. Same will be updated to the database.

8. STAFF  he can perform various functionalities(use cases) like:
1. Leave: can apply for leave to the admin. Same will be updated to the database.
2. Logistics: He can request the supervisor for changes in the logistics. This request will be then processed by the supervisor.
3. UpdateStatus: He will mention his status as free or busy.
4. TaskReport: He will send his task report to the supervisor

LOGOUT: A use case which will be extended from all the above mentioned use cases as the user can opt to logout from the entire system at any point of time.

Login method will contain username and password parameters and the database file will be checked after every successfull login. Else an error message will be shown and user will be asked to login again.
Registration method will contain ID, type, name, username, password, DOB, address, department parameters. Database file will be checked and registration will be successfull if the new user is unique.

Task method will contain taskID, Task Name,Task Description Department,Supervisor, Staff, Equipment, status, deadline as parameters. This method will be called when a new task has to be assigned or the status of a task needs to be seen.

Leave method will contain Leave to Whom, reason, time period as parameters. This method will be called when either supervisor or staff needs to apply for a leave.

Logistic approval request method will have ID, Item with quantities and department as parameters. This method will be called when staff/ supervisor wants to request for material.

Logistic requirement request for task method will have ID, items with quantities, task reference ID as parameters. This method will be called when logistics will be required for the execution of a task.

Task Report method will contain ID, Task ID, Task Name, Task Description, Items used, Time Taken, Comments as parameters. This method will be called when the task report needs to be generated.


    public class GM {
         public static void main(String[] args) {
        /*
           
           1. ask him whether he want to operate on supervisor/staff and then ask for whether he want to add/delete/view them
        if(choice==user)
           if(choice==add)
                add(user)
           else if(choice ==delete)
                delete(user)
           else if(choice==view)
                read(user)
                
             2. ask him if he wants to assign some tasks to someone? If yes, then -->
        if(choice==supervisor)
            task(supervisor)
        else if(choice==staff)
            task(staff)
            
            3. ask him if he wanna work on logistics requests from staff/supervisor or not.
        if(ans==yes)
            check GM text file and search whether he has any request pending or not.
            if(ans==yes)
            
            
    }
    add(String user)
    {
        if(already exists)
                    show a message that it already exists
                else
                    add to it's database(it's text file)
    }
     delete(String user)
    {
        delete from database(his text file)
        if(user==supervisor)
             then ask for new supervisor details --> add to database.
    }
    read(user)
    {
        read user's text file
    }
    task(user)
    {
        1. update user's text file.
        2. also add to task text file.
    }
    */
    
    
    
    public class Staff {
    public static void main(String[] args) {
        {
            /*

                create array list for all the text-documents.
                 1. Ask him whether he want to send request to supervisor. If yes,
                    1. Open Supervisor file. Search for the supervisor with same dept.
                    2. Add request string to it's field.
                2. Ask him whether he want to send leave request to supervisor or not.
                    if yes,
                        1. print(request sent)
                        2. set the status field as "On leave"
                3. Print task text file.
                4. NOTE: all staff lines in it's text file will have a field namely status --> "busy" or "Available" ,  "leave"
                5. print the task report of all those tasks whose status is "complete"
            */
        }
    }        


    public class Supervisor {
    public static void main(String[] args) {
        /*

            create array list for all the text-documents.


          1. ask him whether he want to operate on staff and then ask for whether he want to add/delete/view them
           if(choice==add)
            {
               add()
            }
            else if(choice ==delete)
           {
               delete()
           }
           else if(choice==view)
                read()
           2. ask him if he wants to assign some tasks to someone? If yes, then -->
            task()
           3. ask him if he wanna work on logistics requests from staff or not. if yes-->
           check supervisor's text file and search whether he has any request pending or not.
            if(ans==yes)
                approve those requests(a field) i.e remove them from his line
            else
                print(no request to operate upon)
           4. ask him whether he want to send any request to GM. If yes -->
                1. open GM text file
                2. Add the request string to that file.
           5. Ask him whether he want to send leave to GM.
             NOTE: all supervisor lines in it's text file will have a field namely status --> "busy" or "Available" ,  "leave"
                if yes -->
                    1.print(leave sent)
                    2.set the status field as "on leave"
           6. If he want to view task--> read task text file

    }     
    add()
    {
        --> input the department of that staff member.
                   if(input==supervisor's dept )
                        if(already exists in that dept)
                             show a message that it already exists
                        else
                             add to it's database(it's text file)
                   else
                        print(sorry, can't add some other dept. member)
    }
     delete()
    {
              --> input the department of that staff member.
                   if(input==supervisor's dept )
                        if(already exists in that dept)
                             delete that staff entry
                        else
                               print(doesn't exist)
                   else
                        print(sorry, can't delete some other dept.member)
    }
    read()
    {
        --> input the department of that staff member.
                   if(input==supervisor's dept )
                        if(already exists in that dept)
                             read it's file
                        else
                               print(doesn't exist)
                   else
                        print(sorry, can't view some other dept.member)
     }
     task()
    {

         --> input the department of that staff member.
                   if(input==supervisor's dept )
                        if(already exists in that dept)
                        1. open staff's text file.
                        2. while(ask for the name of the staff member one by one)
                                  {
                                         1. search for that name.
                                         2. update it's task field.
                                         3. Also add to task text file.
                                   }
                        else
                               print( member doesn't exist)
                   else
                        print(sorry, can't view some other dept.member)
    }



         */
                
