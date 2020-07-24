#停车模块  
**given** ParkingBoy Car  
**when**  parkCar  
**then**  Ticket  

**given** ParkingBoy 2Car  
**when**  parkCar  
**then**  2Ticket  

**given** ParkingBoy Car  Full_ParkingLot  
**when**  parkCar   
**then**  no Ticket  

**given** ParkingBoy Car_already_in_ParkingLot  
**when**  parkCar   
**then**  no Ticket  

**given** ParkingBoy   
**when**  parkCar  
**then**  no Ticket  



#取车模块

**given** ParkingBoy Ticket    
**when**  fetchCar     
**then**  Car    

**given** ParkingBoy Ticket  2Car in parkingLot  
**when**  fetchCar     
**then**  right Car    
  
**given** ParkingBoy Wrong Ticket  
**when**  fetchCar     
**then**  no Car    

**given** ParkingBoy  
**when**  fetchCar     
**then**  no Car    

**given** ParkingBoy already_used_Ticket  
**when**  fetchCar     
**then**  no Car    