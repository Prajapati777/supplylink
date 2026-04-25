export class Supplier {
    supplierId: number;
    supplierName: string;
    email: string;
    phone: string;
    address: string;
    username: string;
    password: string;
    role?: string;
    constructor(supplierId: any,supplierName: any,email: any,phone: any,address: any,username: any,password: any,role: any){
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    constuctor(){
        
    }

    displayInfo(): void{
        console.log("Supplier ID : "+this.supplierId);
        console.log("Supplier name : "+this.supplierName);
        console.log("email : " + this.email);
        console.log("Phone : " + this.phone);
        console.log("Address : " + this.address);
        console.log("Username : " + this.username);
        console.log("Password : " + this.password);
        console.log("Role : " + this.role);
    }
    
}



