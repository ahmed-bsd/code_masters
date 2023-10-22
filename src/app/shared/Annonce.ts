export class Annonce{
  idAnnouncement!:number;
  description!:string;
  name!:string;
  localisation!:string ;
  likes!:number;
  dislikes!:number;
  price!:DoubleRange;
  etat!:boolean;
  region!:string;
  image!:string;
  score!:DoubleRange;
  numEvaluations!:number;
  categorieAnnouncement!: CategorieAnnouncement;

  }
  export enum CategorieAnnouncement {
    MaisonAvendre = 'MaisonAvendre',
    MaisonALouer = 'MaisonALouer',
    Villa = 'Villa',
    Appartements = 'Appartements',
    Terrain = 'Terrain'
  }
  

    

