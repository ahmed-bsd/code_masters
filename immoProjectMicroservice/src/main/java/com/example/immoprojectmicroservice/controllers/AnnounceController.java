package com.example.immoprojectmicroservice.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.immoprojectmicroservice.entities.Announce;
import com.example.immoprojectmicroservice.repository.AnnouceRepository;
import com.example.immoprojectmicroservice.service.NearbyPlacesService;
import com.example.immoprojectmicroservice.service.SponsoringService;
import com.example.immoprojectmicroservice.service.StripePaymentService;
import com.example.immoprojectmicroservice.service.ViewsService;

import java.security.Principal;

///****    Developped by Ahmed bsd    ****////
@RestController
@Api(tags = "arr")
@RequestMapping( "api/public")
public class AnnounceController {
	@Autowired
	AnnouceRepository annouceRepository;

	@Autowired
	NearbyPlacesService nearbyPlacesService;

	@Autowired
	ViewsService viewsService;

	@Autowired
	private StripePaymentService stripePaymentService;

	@Autowired
	private SponsoringService sponsoringService;

    //http://localhost:8081/SpringMVC/swagger-ui/index.html

	@ApiOperation(value = "add announce (bsd)")
	@PostMapping("/add/announcement")
	@ResponseBody
	public String add_announcement(@RequestBody Announce ann, @RequestParam Float lg, @RequestParam Float alt) {


		ann.setPharmacies(nearbyPlacesService.nearby(alt,lg,"pharmacy"));
		ann.setSchools(nearbyPlacesService.nearby(alt,lg,"school"));
		ann.setHospitals(nearbyPlacesService.nearby(alt,lg,"hospital"));
		ann.setRestaurants(nearbyPlacesService.nearby(alt,lg,"restaurant"));
        annouceRepository.save(ann);

		return "done , added";

	}

	@ApiOperation(value = "add announcement")
	@GetMapping("/announcement")
	@ResponseBody
	public ResponseEntity<Announce> get_ann(@RequestParam  Long id ) {

		return new ResponseEntity<>(annouceRepository.findById(id).get(), HttpStatus.OK);


	}


	@ApiOperation(value = "add views to announcement")
	@PostMapping("/add/view_announcement")
	@ResponseBody
	public ResponseEntity<String> add_view(@RequestParam  Long id , Principal principal) {



		return new ResponseEntity<>(viewsService.addView(id,principal), HttpStatus.OK);

	}


	@ApiOperation(value = "retrieve sponsored announce by weight")
	@GetMapping("/annoucements")
	@ResponseBody
	public ResponseEntity<?> retrieve_sponsored_announcements() {

		return new ResponseEntity<>(sponsoringService.getSponsoredAnnouncement(), HttpStatus.OK);


	}





/*

	@PostMapping("/purchase")
	public String purchaseOffer(@RequestParam String offer_name,
								@RequestParam double offer_price,
								@RequestParam String card_number,
								@RequestParam String expiry_date,
								@RequestParam String cvc) {
		// Create a Stripe charge using the Stripe API
		Stripe.apiKey = "sk_test_51MjIKuAPfSPmYV8IDHwVr0P3ymi6tD6Rd5MC9ozAnZEbAxLLqOaJhkrmXjZ4Dlz7yfpw5WbR1T16g3EIk0Y9gfm600Yzqewm0r";
		Map<String, Object> chargeParams = new HashMap<>();
		chargeParams.put("amount", (int) (offer_price * 100));
		chargeParams.put("currency", "usd");
		chargeParams.put("description", "Purchase of " + offer_name);
		chargeParams.put("source", card_number);
		chargeParams.put("exp_month", Integer.parseInt(expiry_date.substring(0, 2)));
		chargeParams.put("exp_year", Integer.parseInt(expiry_date.substring(3, 5)));
		chargeParams.put("cvc", cvc);
		try {
			Charge charge = Charge.create(chargeParams);
			// If the charge was successful, return a success page
			return "success";
		} catch (StripeException e) {
			// If there was an error processing the charge, return an error page
			return "error";
		}
	}



*/


}
