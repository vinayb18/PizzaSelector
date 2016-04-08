package commrhardman23.httpsgithub.pizzaselector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CostCalculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost_calculator);

        //constants of cost values
        final double TOPPING_COST = 0.75;
        final double INDIVIDUAL_COST = 8.99;
        final double SMALL_COST = 13.49;
        final double MEDIUM_COST = 20.99;
        final double LARGE_COST = 23.99;
        final double EXTRA_COST = 27.99;
        final double GARLIC_CRUST = 2.00;
        final double THIN_CRUST = 0.00;
        final double THICK_CRUST = 1.50;
        final double CHEESE_FILLED = 3.00;

        //receive information from previous activity by getting extras from Intent
        boolean[] toppingsOnPizza = getIntent().getBooleanArrayExtra("TOPPINGS_BOOLEANS");
        String sizeName = getIntent().getStringExtra("PIZZA_SIZE");
        String crustSelection = getIntent().getStringExtra("CRUST_TYPE");
        boolean hasGarlicCrust = getIntent().getBooleanExtra("GARLIC_CRUST", false);

        //other information that will be needed for displaying totals to user
        int numToppings = 0;
        double toppingCost = 0.0;
        double sizeCost = 0.0;
        String crustName = ""; //will contain both size and whether the crust was garlic crust
        double crustCost = 0.0;
        double subtotal = 0.0;
        double taxes = 0.0;
        double totalCost = 0.0;

        TextView txtvwCostBreakdown = (TextView) findViewById(R.id.txtvwCostBreakdown);

        for(int i = 0; i < toppingsOnPizza.length; i++){
            if(toppingsOnPizza[i] == true){
                numToppings++;
            }
        }

        toppingCost= numToppings * TOPPING_COST;

        if(sizeName.equals("individual")){
            sizeCost= INDIVIDUAL_COST;
        }else if (sizeName.equals("small")){
            sizeCost= SMALL_COST;
        }else if (sizeName.equals("medium")){
            sizeCost= MEDIUM_COST;
        }else if (sizeName.equals("large")) {
            sizeCost= LARGE_COST;
        }else if (sizeName.equals("extra-large")) {
            sizeCost= EXTRA_COST;
        }

        if(crustSelection.equals("thin")){
            crustCost= THIN_CRUST;
            crustName= crustSelection;
        }else if (crustSelection.equals("thick")){
            crustCost= THICK_CRUST;
            crustName= crustSelection;
        }else if (crustSelection.equals("cheese-filled")) {
            crustCost = CHEESE_FILLED;
            crustName= crustSelection;
        }

        if (hasGarlicCrust == true){
            crustCost= crustCost+GARLIC_CRUST;
            crustName= crustName+" + garlic crust";
        }

        // Compute the total cost
        subtotal = toppingCost + sizeCost + crustCost;
        taxes = subtotal * 0.13;
        totalCost = subtotal + taxes;

        String costs = String.format("Toppings: %d x $0.75 = $%.2f\nSize: %s = $%.2f\n" +
                "Crust Type: %s = $%.2f\nSubtotal: $%.2f\nTaxes: $%.2f\nTotal: $%.2f",
                numToppings, toppingCost, sizeName, sizeCost, crustName, crustCost,
                subtotal, taxes, totalCost);

        txtvwCostBreakdown.setText(costs);

    }

    public void backToMenu(View vw){

        Intent makeNewPizza = new Intent();
        setResult(0, makeNewPizza);
        finish();

    }
}
