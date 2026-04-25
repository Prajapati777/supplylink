import { Supplier } from "./Supplier";
export class Warehouse {
    warehouseId: number;
    supplierId: string;
    warehouseName: string;
    location: string;
    capacity: number;
    constructor(warehouseId: any,supplierId: any,warehouseName: any,location: any,capacity: any){
        this.warehouseId = warehouseId;
        this.supplierId = supplierId;
        this.warehouseName = warehouseName;
        this.location = location;
        this.capacity = capacity;
    }

    displayInfo():void{
        console.log("Warehouse ID : " + this.warehouseId);
        console.log("Supplier ID : " + this.supplierId);
        console.log("Warehouse Name : " + this.warehouseName);
        console.log("Location : " + this.location);
        console.log("Capacity : " + this.capacity);
        
    }
}