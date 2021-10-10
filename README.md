Since the past year, the world has been fighting against the COVID-19 onslaught. No single country has survived this deadly virus, not even the holy city of Tanis, and vaccination seems like the only solution ahead. To efficiently manage citizens and hospitals in this sacred city, you have been approached by the Pharaohs from the Ministry of Family Health and Welfare for designing a software application called COVIN (any resemblance to real-life systems is completely unintentional) that allows for a streamlined procedure to citizens, hospitals and officials to manage this difficult task. 
Your application has two chief stakeholders, citizens and hospitals. First, the hospitals should register themselves on the portal and upload their slots, which the citizens can avail themselves of. Each slot must store information such as the day of the slot, the vaccine given in that slot, the available quantity for that slot. Secondly, the citizens should register on the portal and look up different vaccination slots based on hospitals available in a particular area or administering a specific vaccine. They should be able to book slots for that hospital and query the portal for their vaccination details such as vaccine administered and due date of next vaccine. 
Each citizen can register themselves only once, and they must provide their name, age, and a unique ID. Due to the shortage of vaccines, the government only allows vaccination of people above 18 years, so please make sure that no one under 18 can register. The hospitals also need to register themselves on the portal to vaccinate people. They must provide their name and Pincode and will be allotted a unique id. 
The COWIN portal must have details of citizens, hospitals and vaccines available on the portal. Vaccine information such as the name of the vaccine, the number of doses, and the gap between the doses must be added to the COVIN portal before the hospitals can add slots for these vaccines. Once the slots are added and booked by the citizen, it is assumed that he/she gets vaccinated immediately. Make sure that for a particular day and hospital, the number of citizens registered for that slot does not exceed the maximum available slots, and the chosen slot does not violate the stipulated duration between slots. 
The Pharaohs are well aware that building a GUI system takes too much time, and they are ready to accept a command-line version of the software. You must use Object-Oriented programming concepts taught in the lectures for your implementation. A detailed description of the functions that your app must implement is provided to you below along with a sample run of your app.
Builtin Data Structures are allowed but with proper justification for their use. HINT: SLOT is one of the 5-6 classes that will be implemented for this assignment

Different tasks to perform: 

1. Add Vaccine: 
Input: Name, Number of total doses required, Gap Between Doses 
Output: Display the added vaccine details 

2. Register Hospital: 
Input: Name, Pincode 
Output: Display the added hospital details along with the generated unique hospital ID (A 6 digit number) 

3. Register Citizen: 
Input: Name, Age, Unique ID (A 12 digit numeric ID like Aadhar ID) 
Output: Display the citizen details and set his/her vaccination status as "REGISTERED." 

4. Create Slots: 
Input: Hospital ID followed by the number of slots that the hospital wants to add. For each slot, enter the day number and quantity followed by selecting the vaccine for that slot. 
Output: Display the details of the added slot. 

5. Book a Slot: 
Input: Unique ID of the citizen followed by 2 options to search: {By Pincode, By Vaccine}. A successful search should show a list of possible hospitals. Upon selecting the chosen hospital, their available slots must be reflected, and a chosen slot must be booked. 
Output: Display the citizen vaccinated along with the vaccine. Change the status of the citizen to PARTIALLY VACCINATED/FULLY VACCINATED accordingly. 

6. Slots available with a hospital 
Input: Hospital ID 
Output: List all slots for the chosen hospital

7. Check vaccination status: 
Input: Citizen inputs his/her Unique ID to check current status 
Output: Display the current vaccination status: REGISTERED/PARTIALLY VACCINATED/FULLY VACCINATED along with the vaccine administered, number of doses given, and the due date of next vaccination (in case of partial vaccination). 
SAMPLE RUN 
CoWin Portal initialized.... 
--------------------------------- 
1. Add Vaccine 
2. Register Hospital 
3. Register Citizen 
4. Add Slot for Vaccination 
5. Book Slot for Vaccination 
6. List all slots for a hospital 
7. Check Vaccination Status 
8. Exit 
--------------------------------- 
1 
Vaccine Name: Covax 
Number of Doses: 2 
Gap between Doses: 2 
Vaccine Name: Covax, Number of Doses: 2, Gap Between Doses: 2 
--------------------------------- 
{Menu Options} 
1 
Vaccine Name: Covi 
Number of Doses: 1 
Vaccine Name: Covi, Number of Doses: 1, Gap Between Doses: 0 
--------------------------------- 
{Menu Options} 
2 
Hospital Name: Medistar 
PinCode: 110091 
Hospital Name: Medistar, PinCode: 110091, Unique ID: 123456 
--------------------------------- 
{Menu Options} 
2 
Hospital Name: HealthCenter 
PinCode: 110001
Hospital Name: HealthCenter, PinCode: 110001, Unique ID: 111111 --------------------------------- 
{Menu Options} 
4 
Enter Hospital ID: 123456 
Enter number of Slots to be added: 2 
Enter Day Number: 1 
Enter Quantity: 5 
Select Vaccine 
0. Covax 
1. Covi 
0 
Slot added by Hospital 123456 for Day: 1, Available Quantity: 5 of Vaccine Covax Enter Day Number: 2 
Enter Quantity: 5 
Select Vaccine 
0. Covax 
1. Covi 
1 
Slot added by Hospital 123456 for Day: 2, Available Quantity: 5 of Vaccine Covi --------------------------------- 
{Menu Options} 
6 
Enter Hospital Id: 123456 
Day: 1 Vaccine: Covax Available Qty: 5 
Day: 2 Vaccine: Covi Available Qty: 5 
--------------------------------- 
{Menu Options} 
4 
Enter Hospital ID: 111111 
Enter number of Slots to be added: 1 
Enter Day Number: 3 
Enter Quantity: 10 
Select Vaccine 
0. Covax 
1. Covi 
0 
Slot added by Hospital 111111 for Day: 3, Available Quantity: 10 of Vaccine Covax ---------------------------------
{Menu Options} 
3 
Citizen Name: Justin 
Age: 14 
Unique ID: 123456654321 
Citizen Name: Justin, Age: 14, Unique ID: 123456654321 Only above 18 are allowed 
--------------------------------- 
{Menu Options} 
3 
Citizen Name: Marrion 
Age: 23 
Unique ID: 123456789000 
Citizen Name: Marrion, Age: 23, Unique ID: 123456789000 --------------------------------- 
{Menu Options} 
5 
Enter patient Unique ID: 123456789000 
1. Search by area 
2. Search by Vaccine 
3. Exit 
Enter option: 1 
Enter PinCode: 110091 
123456 Medistar 
Enter hospital id: 123456 
0-> Day: 1 Available Qty:5 Vaccine:Covax 
1-> Day: 2 Available Qty:5 Vaccine:Covi 
Choose Slot: 0 
Marrion vaccinated with Covax 
--------------------------------- 
{Menu Options} 
7 
Enter Patient ID: 123456789000 
PARTIALLY VACCINATED 
Vaccine Given: Covax 
Number of Doses given: 1 
Next Dose due date: 3 
--------------------------------- 
{Menu Options} 
5 
Enter patient Unique ID: 123456789000
1. Search by area 
2. Search by Vaccine 
3. Exit 
Enter option: 2 
Enter Vaccine name: Covax 
123456 Medistar 
111111 HealthCenter 
Enter hospital id: 123456 
No slots available 
--------------------------------- 
{Menu Options} 
5 
Enter patient Unique ID: 123456789000 1. Search by area 
2. Search by Vaccine 
3. Exit 
Enter option: 2 
Enter Vaccine name: Covax 
123456 Medistar 
111111 HealthCenter 
Enter hospital id: 111111 
2-> Day: 3 Available Qty:10 Vaccine:Covax Choose Slot: 2 
Marrion vaccinated with Covax 
--------------------------------- 
{Menu Options} 
7 
Enter Patient ID: 123456789000 FULLY VACCINATED 
Vaccine Given: Covax 
Number of Doses given: 2 
--------------------------------- 
{Menu Options} 
6 
Enter Hospital Id: 123456 
Day: 1 Vaccine: Covax Available Qty: 4 Day: 2 Vaccine: Covi Available Qty: 5 --------------------------------- 
{Menu Options} 
3 
Citizen Name: Mutt
Age: 45 
Unique ID: 454545656565 
Citizen Name: Mutt, Age: 45, Unique ID: 454545656565 --------------------------------- 
{Menu Options} 
7 
Enter Patient ID: 454545656565 
Citizen REGISTERED 
--------------------------------- 
{Menu Options} 
3 
Citizen Name: Oxley 
Age: 67 
Unique ID: 999999000000 
Citizen Name: Oxley, Age: 67, Unique ID: 999999000000 --------------------------------- 
{Menu Options} 
5 
Enter patient Unique ID: 999999000000 
1. Search by area 
2. Search by Vaccine 
3. Exit 
Enter option: 2 
Enter Vaccine name: Covi 
123456 Medistar 
Enter hospital id: 123456 
1-> Day: 2 Available Qty:5 Vaccine:Covi 
Choose Slot: 1 
Oxley vaccinated with Covi 
--------------------------------- 
{Menu Options} 
7 
Enter Patient ID: 999999000000 
FULLY VACCINATED 
Vaccine Given: Covi 
Number of Doses given: 1 
--------------------------------- 
{Menu Options} 
8 
{End of Test Case}
