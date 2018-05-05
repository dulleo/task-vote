/*
interface Serializable<T> {
    deserialize( input: Object ): T;
}*/

export class Task  {    //implements Serializable<Task>{
    private id: string;
    private name: string;
    private upVote: number;
    private downVote: number;

    getId(): string {
        return this.id;
    }
    setId(id: string) : void {
       this.id = id; 
    }

    getName() : string {
        return this.name;
    }
    setName(name: string) : void {
        this.name = name;
    }

    getUpVote() : number {
        return this.upVote;
    }
    setUpVote(upVote: number) : void {
        this.upVote = upVote;
    }

    getDownVote() : number {
        return this.downVote;
    }
    setDownVote(downVote: number) : void {
        this.downVote = downVote;
    }

    /*
    deserialize( json: any ) {
        this.id = json.id;
        this.name = json.name;
        this.upVote = json.upVote;
        this.downVote = json.downVote;
        return this;
    }

    deserializeList(json: any) {
        let tasks: Array<Task> = [];

        if (json != null) {
          for (var i = 0; i < json.length; i++) {
            var data = json[i];
            var task: Task = new Task().deserialize(data);
            tasks.push(task);
          }
        }
        return tasks;
      }*/
}