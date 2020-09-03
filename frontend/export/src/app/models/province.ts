import { BuildingType } from './buildingType';
export class Province {
    province: String;
    //Maximum number of persons in an indoor Gathering
    personsIndoor: number;
    personsOutdoor: number;
    householdsIndoor: number;
    householdsOutdoor: number;
    maskMandatory: boolean;
    closedBuildingTypes: BuildingType[];
    //Person per square meter indoors
    personsPsmIndoor: number;
    //Person per square meter outdoors
    personsPsmOutdoor: number;
    other: String;

    constructor(obj?: any){
        Object.assign(this, obj);
    }

}