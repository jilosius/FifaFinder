export interface Spieler {
    playerId: number;
    photoURL: string;
    fifaVersion: number;
    fullName: string;
    knownName: string;
    age: number;
    flag: string;
    clubName: number;
    clubLogo: string;
    overall: number;
    potential: number;
    bestPos: string;
    valueEUR: number;
    height: number;
    weight: number;
//------------------------------------
// Hidden columns
    preferredFoot: string;
    headingAccuracy: number;
    volleys: number;
    dribbling: number;
    curve: number;
    fkAccuracy: number;
    acceleration: number;
    sprintSpeed: number;
    agility: number;
    reaction: number;
    balance: number;
    shotPower: number;
    jumping: number;
    stamina: number;
    aggression: number;
    longShots: number;
    crossing: number;
    finishing: number;
    shortPassing: number;
    wage: number;

    selected: boolean;

}

