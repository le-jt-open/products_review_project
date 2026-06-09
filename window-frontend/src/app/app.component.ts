
import { Component, OnInit } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  template: `
  <div>
    <h1>Dashboard</h1>
    <div>
      <p>Products: {{productCount}}</p>
      <p>Reviews: {{reviewCount}}</p>
    </div>

    <h2>Top Rated</h2>
    <div *ngFor="let p of topProducts">
      <div class="card">{{p.name}}</div>
    </div>

    <h2>Worst Rated</h2>
    <div *ngFor="let p of worstProducts">
      <div class="card">{{p.name}}</div>
    </div>

    <h2>All Products</h2>
    <div *ngFor="let p of allProducts">
      <div>{{p.name}}</div>
    </div>
  </div>
  `,
})
export class AppComponent implements OnInit {

  productCount = 0;
  reviewCount = 0;
  topProducts: any[] = [];
  worstProducts: any[] = [];
  allProducts: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.http.get<number>('http://localhost:8080/api/products/count')
      .subscribe(data => this.productCount = data);

    this.http.get<number>('http://localhost:8080/api/reviews/count')
      .subscribe(data => this.reviewCount = data);

    this.http.get<any[]>('http://localhost:8080/api/products/rating/highest')
      .subscribe(data => this.topProducts = data);

    this.http.get<any[]>('http://localhost:8080/api/products/rating/lowest')
      .subscribe(data => this.worstProducts = data);

    this.http.get<any[]>('http://localhost:8080/api/products')
      .subscribe(data => this.allProducts = data);
  }
}
