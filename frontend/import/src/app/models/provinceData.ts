import { Province } from './province';
export class ProvinceData{

    dataForAllProvinces: Province[] = [
        {province: 'Niedersachsen', personsIndoor: 10, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:["Schulen"], personsPsmIndoor: 1, personsPsmOutdoor: 2, other:''},
        {province: 'Nrw', personsIndoor: 8, personsOutdoor:40, householdsIndoor: 4, householdsOutdoor: 8, maskMandatory: false, buildingTypesClosed:["Schulen"], personsPsmIndoor: 2, personsPsmOutdoor: 5, other:''},
        {province: 'Bayern', personsIndoor: 12, personsOutdoor:50, householdsIndoor: 5, householdsOutdoor: 10, maskMandatory: true, buildingTypesClosed:["Biergärten"], personsPsmIndoor: 4, personsPsmOutdoor: 6, other:'Kein Bier macht uns traurig'}
    ];

    constructor(){

    }



}
