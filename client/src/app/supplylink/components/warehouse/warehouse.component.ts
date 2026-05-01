import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-warehouse',
  templateUrl: './warehouse.component.html',
  styleUrls: ['./warehouse.component.scss']
})
export class WarehouseComponent implements OnInit {

  warehouseForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.warehouseForm = this.fb.group({
      warehouseId: [''],
      supplierId: ['', [Validators.required, Validators.min(1)]],
      warehouseName: ['', Validators.required],
      location: [''],
      capacity: ['', [Validators.required, Validators.min(0)]]
    });
  }

  get warehouseId() {
    return this.warehouseForm.get('warehouseId');
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

  onSubmit(): void {
    if (this.warehouseForm.valid) {
      console.log('Warehouse Form Data:', this.warehouseForm.value);
      alert('Warehouse details submitted successfully!');
    } else {
      this.warehouseForm.markAllAsTouched();
    }
  }
}