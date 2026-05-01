import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  productForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    this.productForm = this.fb.group({
      productId: [''],
      warehouseId: ['', [Validators.required, Validators.min(1)]],
      productName: ['', Validators.required],
      productDescription: [''],
      quantity: ['', [Validators.required, Validators.min(0)]],
      price: ['', [Validators.required, Validators.min(1)]]
    });
  }

  get productId() {
    return this.productForm.get('productId');
  }

  get warehouseId() {
    return this.productForm.get('warehouseId');
  }

  get productName() {
    return this.productForm.get('productName');
  }

  get productDescription() {
    return this.productForm.get('productDescription');
  }

  get quantity() {
    return this.productForm.get('quantity');
  }

  get price() {
    return this.productForm.get('price');
  }

  onSubmit(): void {
    if (this.productForm.valid) {
      console.log('Product Form Data:', this.productForm.value);
      alert('Product details submitted successfully!');
    } else {
      this.productForm.markAllAsTouched();
    }
  }
}