# Story1  

### 停车模块    
-------------------------------  
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

**given** ParkingBoy   no_car
**when**  parkCar  
**then**  no Ticket  



#### 取车模块 
----------
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

# Story2

**given** ParkingBoy Wrong_Ticket  
**when**  fetchCar     
**then**  Unrecognized parking ticket.

**given** ParkingBoy already_used_Ticket  
**when**  fetchCar     
**then**  Unrecognized parking ticket.
 
**given** ParkingBoy no_Ticket  
**when**  fetchCar     
**then**  Please provide your parking ticket.
  
**given** ParkingBoy Car Full_ParkingLot  
**when**  parkCar   
**then**  Not enough position. 

# Story3
**given** ParkingBoy Car multiple_parking_lot(fitst parkingLot full)  
**when**  parkCar  
**then**  car part in second_part_lot  

# Story4  
**given** SmartParkingBoy Car parking_lot_2(already part 3 car),parking_lot_2(already part 2 car)  
**when**  parkCar  
**then**  park car in contains more empty positions