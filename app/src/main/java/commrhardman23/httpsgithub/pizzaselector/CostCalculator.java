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

        //all information needed for cost breakdown that is sent through extras in the intent
        int numToppings = 0;
        double toppingCost = 0.0;
        String sizeName = "";
        double sizeCost = 0.0;
        String crustName = "";
        double crustCost = 0.0;
        double subtotal = 0.0;
        double taxes = 0.0;
        double totalCost = 0.0;

        TextView txtvwCostBreakdown = (TextView) findViewById(R.id.txtvwCostBreakdown);
        boolean[] toppingsOnPizza = getIntent().getBooleanArrayExtra("TOPPINGS_BOOLEANS");

        //your code here

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
