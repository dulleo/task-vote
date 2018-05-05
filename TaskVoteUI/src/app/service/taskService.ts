import { Injectable } from '@angular/core';
import { HttpClient, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import * as EventSource from 'eventsource';

import { Task } from '../model/task';

@Injectable()
export class TaskService {
    
    private baseUrl = 'http;//localhost:8080/tasks';
    private tasks: Task[] = new Array();

    constructor(private httpClient: HttpClient) {}

    getAllTask() : Observable<any> {
        return this.httpClient.get(`${this.baseUrl}`)
    }
}