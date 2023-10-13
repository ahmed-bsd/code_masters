package com.example.immomicroservice.Service;

import com.example.immomicroservice.Repository.InvestissmentRepository;
import com.example.immomicroservice.entities.EstimatePrice;
import com.example.immomicroservice.entities.Investissement;
import com.example.immomicroservice.entities.LoanResult;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class InvestissmentService {

    InvestissmentRepository investismentRepository;


    public EstimatePrice estimatePrice(Investissement inv) {
        String category=inv.getCategory();
        String city=inv.getCity();
        String region=inv.getRegion();
        String type=inv.getType();
        String roomsCount= inv.getRoomsCount();
        List<Investissement> investisments = investismentRepository.findInvestissementByCategoryAndCityAndRegion(category,city,region,type);
        System.out.println(investisments);
        List<String> data=new ArrayList<>();
        if (category == "Appartements" || category=="Maisons et Villas") {

            float bienVenteMax = investismentRepository.findMaxInvestA(roomsCount,category, city, region, type);
            String max = String.format("%.0f", bienVenteMax);
            float bienMin = investismentRepository.findMinInvestA(roomsCount,category,city,region,type);
            String min = String.format("%.0f", bienMin);
            float moyenne = investismentRepository.averageA(roomsCount,category,city,region,type);
            String moy = String.format("%.0f", moyenne);
            System.out.println("max :"  +max+"\n min :"  +min+"\nmoyenne :"  +moy);
            return new EstimatePrice(max, min, moy);
        }else{
            float bienVenteMax = investismentRepository.findMaxInvest(category, city, region, type);
            String max = String.format("%.0f", bienVenteMax);
            float bienMin = investismentRepository.findMinInvest(category,city,region,type);
            String min = String.format("%.0f", bienMin);
            float moyenne = investismentRepository.average(category,city,region,type);
            String moy = String.format("%.0f", moyenne);

            System.out.println("max :"  +max+"\n min :"  +min+"\nmoyenne :"  +moy);
            // return " \nmax prices found :"  +max+"\n lowest price is :"  +min+"\n to buy a property you must have about :"  +moy;
            return new EstimatePrice(max, min, moy);
        }

    }
    public static String formatNumber(double number) {
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(number);
    }



    public LoanResult finCalculator(float Propertyprice, int loanTermInYears, double autoFinanced) {
        //double Propertyprice = investisment.getPrice();
        List<Investissement> less3Prices=investismentRepository.findLessPrices(Propertyprice);
        List<Investissement> top3 = new ArrayList<>();
        double tauxIntert = 7.96;
        double tauxInteretMensuel =( tauxIntert / 12)/100;
        //exple sur 5 annee ==> 5*12 pour avoir le nbr de mois
        int numberOfPayments = loanTermInYears * 12;
        double resteApayer = Propertyprice - autoFinanced;
        //La formule permettant de connaître ses mensualités:
        // [ (resteApayer* tauxInteretMensuel *(1+tauxInteretMensuel)^nbr de mois ] / (1+tauxInteretMensuel)^nbr de mois -1
        double numerator = tauxInteretMensuel * Math.pow(1 + tauxInteretMensuel, numberOfPayments);
        double denominator = Math.pow(1 + tauxInteretMensuel, numberOfPayments) - 1;

        for (Investissement i : less3Prices){
            double propPrice=i.getPrice();
            double resteApayer1 = propPrice - autoFinanced;
            double numerator1 = tauxInteretMensuel * Math.pow(1 + tauxInteretMensuel, numberOfPayments);
            double denominator2 = Math.pow(1 + tauxInteretMensuel, numberOfPayments) - 1;
            double cal = resteApayer1 * (numerator1 / denominator2);
            String formattedMonthlyPayment = String.format("%.2f", cal).replace(",", ".");

            top3.add(i);
            i.setMonthlyPayment(Double.parseDouble(formattedMonthlyPayment));
            //top3.add("\n #\n" +"Region :"+i.getRegion()+"\nPrice :"+ i.getPrice()+"\nCategory :"+i.getCategory()+"\nRooms :"+i.getRoomsCount()+"\nsuperficie :"+i.getSize() + "\n --> Le montant mensuel de votre prêt est de: " + resteApayer1 + " dinars"); // ajouter le calcul de prêt pour chaque maison à la liste

        }
        double monthlyPayment = resteApayer * (numerator / denominator);
        String formattedMonthlyPayment = String.format("%.2f", monthlyPayment).replace(",", ".");


        return new LoanResult(Double.parseDouble(formattedMonthlyPayment) ,top3);
        // +"\n the top three properties where you can invest : \n"+top3;

    }

    public List <Investissement> choiceInvest(Investissement inv){
        //List<Investisment> invests = investismentRepository.findAll();
        String category=inv.getCategory();
        String city=inv.getCity();
        String region=inv.getRegion();
        String type=inv.getType();

        List<Investissement> investisments = investismentRepository.findInvestissementByCategoryAndCityAndRegion(category,city,region,type);



        return investisments;
    }





}
