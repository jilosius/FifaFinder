export interface Spieler {
    photoURL: string;
    knownName: string;
    age: number;
    flag: string;
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
}
