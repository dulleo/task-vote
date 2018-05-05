import { Component } from '@angular/core';
import { Task } from './model/task'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  /*
  tasks: Array<Task> = [];
  private ws = new WebSocket('ws://localhost:8080/ws/tasks')

  constructor() {
    this.ws.onmessage = (me: MessageEvent) => {
      const data = JSON.parse(me.data) as Task;
      this.tasks.push(data);
    }
  }*/
  
}
