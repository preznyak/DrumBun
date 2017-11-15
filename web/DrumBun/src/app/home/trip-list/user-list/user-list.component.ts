import {Component, Injectable, OnInit} from '@angular/core';
import { UserService } from "../../../_shared/user.service";
import { UserdetailsModel } from "../../../_models/userdetails.model";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [UserService]
})
@Injectable()
export class UserListComponent implements OnInit {

  private users: UserdetailsModel[];

  constructor(private userService: UserService) { }

  ngOnInit() { //when component loading get all users and set the users[]
    this.getAllUsers();
  }

  getAllUsers() {
    this.userService.findAll().subscribe(
      users => {
        this.users = users;
      },
      err => {
        console.log(err);
      }

    );
  }

}
