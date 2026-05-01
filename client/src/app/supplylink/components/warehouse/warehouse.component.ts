import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss']
})
export class WarehouseComponent implements OnInit {

  warehouseForm!: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.warehouseForm = this.fb.group({
      supplierId: ['', [Validators.required, Validators.min(1)]],
      warehouseName: ['', Validators.required],
      location: [''],
      capacity: ['', [Validators.required, Validators.min(0)]]
    });
  }

  get supplierId() {
    return this.warehouseForm.get('supplierId');
  }

  get warehouseName() {
    return this.warehouseForm.get('warehouseName');
  }

  get location() {
    return this.warehouseForm.get('location');
  }

  get capacity() {
    return this.warehouseForm.get('capacity');
  }

  simulateBackendError(): boolean {
    const existingWarehouseNames = ['Central Warehouse', 'Main Warehouse', 'Supply Hub'];
    const enteredWarehouseName = this.warehouseForm.value.warehouseName;

    return existingWarehouseNames.includes(enteredWarehouseName);
  }

  onSubmit(): void {
    this.successMessage = '';
    this.errorMessage = '';

    if (this.warehouseForm.valid) {

      if (this.simulateBackendError()) {
        this.errorMessage = 'Warehouse name already exists. Please enter a different warehouse name.';
        return;
      }

      console.log('Warehouse Form Data:', this.warehouseForm.value);
      this.successMessage = 'Warehouse details submitted successfully!';
      alert('Warehouse details submitted successfully!');

    } else {
      this.warehouseForm.markAllAsTouched();
      this.errorMessage = 'Please fill all required fields correctly.';
    }
  }
}