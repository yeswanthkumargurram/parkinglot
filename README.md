# parkinglot
**Parking Lot**
Enum Status (open/close/underRepair),
List<Gate>,
List<Floor>,
Vehicle,
SlotAllotmentStrategyType,
FeeCalculationStrategyType,
Address

**ParkingFloor**
int id (which will be unique whole over the world as this is a centralized parking system),
int floorNumber (which is unique only for the particular location),
List<Slot>,
Enum status

**ParkingSlot**
id,
Enum vehicleType(bike, car, bus),
Enum status,
number,
floor

**Vehicle**
id,
type,
nameOfOwner,
vehicleNumber,
Slot

**Gate**
id,
type,
number,
operator,
status

**Ticket**
id,
Vehicle,
entryTime,
Slot,
gate,
operator

**Operator**
employeeId,
name

**Bill**
id,
amount,
exitTime,
payment,
Gate,
Ticket,
FeeCalculationStratregy,
operator

**Payment**
id,
mode,
amount,
time,
status,
ref number

