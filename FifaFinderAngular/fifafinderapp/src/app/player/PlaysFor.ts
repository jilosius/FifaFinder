export interface PlaysFor{
    yProperty: any;
    height: number ;
    id: {
    playerID:number ;
    fifaVersion :number;  },    
    clubPosition:string ;
    clubNumber:number;
    nationalPosition: string ;
    nationalNumber: number ;
    preferredFoot: string ;
    contractUntil: number ;
    onLoan: string ;
    nationalTeam: string ;
    age: number ;
    weight: number ;
    overall: number ;
    potential: number ;
    bestPosition: string ;
    Mannschaften :number;
    valueEUR: number ;
    wage: number ;
    releaseClause: number ;
    intReputation: number ;
    weakFoot: number ;
    skillMoves: number ;
    crossing: number ;
    finishing: number ;
    headingAccuracy: number ;
    shortPassing: number ;
    volleys: number ;
    dribbling: number ;
    curve: number ;
    fKAccuracy: number ;
    numberPassing: number ;
    ballControl: number ;
    acceleration: number ;
    sprintSpeed: number ;
    agility: number ;
    reaction: number ;
    balance: number ;
    shotPower: number ;
    jumping: number ;
    stamina: number ;
    strength: number ;
    numberShots: number ;
    aggression: number ;
    interceptions: number ;
    positioning: number ;
    vision: number ;
    penalties: number ;
    composure: number ;
    marking: number ;
    standingTackle: number ;
    slidingTackle: number ;
    gkdiving: number ;
    gkhandling: number ;
    gkkicking: number ;
    gkpositioning: number ;
    gkreflexes: number ;
    photoUrl: string ;
    clubID :{
  
      id: number,
      clubName:string,
      clubLogo: string,
      hibernateLazyInitializer:{}
      

  }
  
}


export interface Spieler {
    id: number;
    knownName: string;
    fullName: string;
    birthDate: string;
    countryName: string;
    flag:string;
  }

export   interface DataPoint {
    x: any;
    y: any;
    
  };


export interface Mannschaften {

  id: number;
  clubName: string ,
  league: string,
  logo:string,
  countryName :string,
  flag: string,
  overall:number,
  attack:number,
  midfield:number,
  defence:number,
  clubLogo:string}


  