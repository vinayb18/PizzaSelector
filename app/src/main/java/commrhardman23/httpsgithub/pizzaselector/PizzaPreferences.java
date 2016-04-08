package commrhardman23.httpsgithub.pizzaselector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class PizzaPreferences extends AppCompatActivity {

    private CheckBox[] toppings;
    private RadioButton rdobtnIndividual;
    private RadioButton rdobtnSmall;
    private RadioButton rdobtnMedium;
    private RadioButton rdobtnLarge;
    private RadioButton rdobtnExtraLarge;
    private RadioButton rdobtnThin;
    private RadioButton rdobtnThick;
    private RadioButton rdobtnCheeseFilled;
    private CheckBox chkboxGarlic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_preferences);

        toppings = new CheckBox[]{
                (CheckBox)findViewById(R.id.chkboxPepperoni),
                (CheckBox)findViewById(R.id.chkboxHam),
                (CheckBox)findViewById(R.id.chkboxBacon),
                (CheckBox)findViewById(R.id.chkboxSausage),
                (CheckBox)findViewById(R.id.chkboxMushrooms),
                (CheckBox)findViewById(R.id.chkboxGreenPeppers),
                (CheckBox)findViewById(R.id.chkboxOnions),
                (CheckBox)findViewById(R.id.chkboxOlives),
                (CheckBox)findViewById(R.id.chkboxTomatoes),
                (CheckBox)findViewById(R.id.chkboxExtraCheese)
        };

        rdobtnIndividual = (RadioButton)findViewById(R.id.rdobtnIndividual);
        rdobtnSmall = (RadioButton)findViewById(R.id.rdobtnSmall);
        rdobtnMedium = (RadioButton)findViewById(R.id.rdobtnMedium);
        rdobtnLarge = (RadioButton)findViewById(R.id.rdobtnLarge);
        rdobtnExtraLarge = (RadioButton)findViewById(R.id.rdobtnExtraLarge);
        rdobtnThin = (RadioButton)findViewById(R.id.rdobtnThin);
        rdobtnThick = (RadioButton)findViewById(R.id.rdobtnThick);
        rdobtnCheeseFilled = (RadioButton)findViewById(R.id.rdobtnCheeseFilled);
        chkboxGarlic = (CheckBox)findViewById(R.id.chkboxGarlic);
    }

    /**
     * calculateCost will loop through the topping array, check size of the pizza, and check the
     * crust options for the pizza so that the CostCalculator activity can give a full description
     * of costs.
     * @param vw is the button associated with the calculateCost method
     */
    public void calculateCost(View vw){

        Intent calculatePizzaCost = new Intent(this, CostCalculator.class);
        boolean[] hasToppings = new boolean[toppings.length];
        String size = "";
        String crust= "";
        boolean garlic= false;

        //insert your code here
        for(int i = 0; i < toppings.length; i++){
            if(toppings[i].isChecked()){
                hasToppings[i] = true;
            }
        }

        if(rdobtnIndividual.isChecked()){
            size="individual";
        } else if (rdobtnSmall.isChecked()){
            size="small";
        } else if (rdobtnMedium.isChecked()){
            size= "medium";
        } else if (rdobtnLarge.isChecked()) {
            size = "large";
        } else if (rdobtnExtraLarge.isChecked()) {
            size = "extra-large";
        }

        if(rdobtnThin.isChecked()){
            crust="thin";
        } else if (rdobtnThick.isChecked()){
            crust="thick";
        } else if (rdobtnCheeseFilled.isChecked()){
            crust= "cheese-filled";
        }

        if (chkboxGarlic.isChecked()) {
            garlic= true;
        }

        calculatePizzaCost.putExtra("TOPPINGS_BOOLEANS", hasToppings);
        calculatePizzaCost.putExtra("PIZZA_SIZE", size);
        calculatePizzaCost.putExtra("CRUST_TYPE", crust);
        calculatePizzaCost.putExtra("GARlIC_CRUST", garlic);
        startActivityForResult(calculatePizzaCost, 0);
    }

    /**
     * onActivityResult is the code that is run upon completion of the Intent linked to this
     * activity. The code below deselects all checkboxes and radio buttons for another selection
     * @param requestCode is the number linking the original activity and the intent created
     * @param resultCode is the number that represents whether the operation was successful
     *                   or unsuccessful
     * @param data is the intent used to return back to the original activity
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        for(int i = 0; i < toppings.length; i++){
            toppings[i].setChecked(false);
        }
        rdobtnIndividual.setChecked(false);
        rdobtnSmall.setChecked(false);
        rdobtnMedium.setChecked(false);
        rdobtnLarge.setChecked(false);
        rdobtnExtraLarge.setChecked(false);
        rdobtnThin.setChecked(false);
        rdobtnThick.setChecked(false);
        rdobtnCheeseFilled.setChecked(false);
        chkboxGarlic.setChecked(false);
    }
}
