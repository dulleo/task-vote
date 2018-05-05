import { Vote } from "./vote";

/*
interface Serializable<T> {
    deserialize( input: Object ): T;
}*/

export class TaskVoteDTO {
    id: string;
    vote: Vote;

    getId(): string {
        return this.id;
    }
    setId(id: string) : void {
       this.id = id; 
    }

    getVote() : Vote {
        return this.vote;
    }
    setVote(vote: Vote) : void {
        this.vote = vote;
    }

    /*
    deserialize( json: any ) {
        this.id = json.id;
        this.vote = json.vote;
        return this;
    }*/
}