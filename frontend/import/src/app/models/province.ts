export class Province {
    name: String;
    //Maximum number of persons in an indoor Gathering
    personsIndoor: number;
    personsOutdoor: number;
    householdsIndoor: number;
    householdsOutdoor: number;
    maskMandatory: boolean;
    buildingTypesClosed: String[];
    //Person per square meter indoors
    personsPsmIndoor: number;
    //Person per square meter outdoors
    personsPsmOutdoor: number;
    other: String;

    constructor(){
        
    }

}