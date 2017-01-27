import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

// Import rxjs map operator
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'app works!';

  // Link to our api, pointing to localhost
  API = 'http://localhost:3000';

  // Declare empty list of members
  members: any[] = [];

  constructor(private http: Http) {}

  // Angular 2 Life Cycle event when component has been initialized
  ngOnInit() {
    this.getAllMember();
  }

  // Add one person to the API
  addMember(name, age, nickname, role) {
    this.http.post(`${this.API}/members`, {name, age, nickname, role})
      .map(res => res.json())
      .subscribe(() => {
        this.getAllMember();
      })
  }

  // Get all users from the API
  getAllMember() {
    this.http.get(`${this.API}/members`)
      .map(res => res.json())
      .subscribe(members => {
        console.log(members);
        this.members = members
      })
  }
}
