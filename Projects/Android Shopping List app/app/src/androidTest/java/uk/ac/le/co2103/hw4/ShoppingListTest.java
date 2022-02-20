package uk.ac.le.co2103.hw4;

import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4ClassRunner.class)
public class ShoppingListTest {
    public static ViewAction customswipeRight() {return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.CENTER_LEFT,GeneralLocation.CENTER_RIGHT, Press.FINGER);}
    private View decorView;
    @Rule
    public ActivityScenarioRule rule = new ActivityScenarioRule<>(MainActivity.class);

//    @Rule
//    public ActivityTestRule<ShoppingListActivity> activityTestRule =
//            new ActivityTestRule<>(ShoppingListActivity.class);

    @BeforeClass
    public static void clearDB() {
        InstrumentationRegistry.getInstrumentation()
                .getTargetContext().deleteDatabase("shopping_db");
    }

    @Test
    public void testAddNewList() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.editTextShopListName)).check(matches(isDisplayed()));
        onView(withId(R.id.button_create)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextShopListName)).perform(typeText("Birthday Party"),
                closeSoftKeyboard());
        onView(withId(R.id.button_create)).perform(click());
        onView(withText("Birthday Party")).check(matches(isDisplayed()));

    }

    @Test
    public void testDeleteList() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.editTextShopListName)).check(matches(isDisplayed()));
        onView(withId(R.id.button_create)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextShopListName)).perform(typeText("Birthday Party"),
                closeSoftKeyboard());
        onView(withId(R.id.button_create)).perform(click());
        onView(withText("Birthday Party")).check(matches(isDisplayed()));
        onView(withText("Birthday Party")).perform(customswipeRight());
        onView(withText("Birthday Party")).check(doesNotExist());
    }

    @Test
    public void testAddProduct() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.editTextShopListName)).check(matches(isDisplayed()));
        onView(withId(R.id.button_create)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextShopListName)).perform(typeText("Birthday Party"),
                closeSoftKeyboard());
        onView(withId(R.id.button_create)).perform(click());
        onView(withText("Birthday Party")).check(matches(isDisplayed()));

        onView(withText("Birthday Party")).perform(click());
        onView(withId(R.id.fabAddProduct)).perform(click());
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextQuantity)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.button_Add)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextName)).perform(typeText("Cake"),
        closeSoftKeyboard());
        onView(withId(R.id.editTextQuantity)).perform(typeText("1"),
                closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Unit"))).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withText("Cake 1 Unit")).check(matches(isDisplayed()));


    }

    @Test
    public void testAddDuplicateProduct() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.editTextShopListName)).check(matches(isDisplayed()));
        onView(withId(R.id.button_create)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextShopListName)).perform(typeText("Birthday Party"),
                closeSoftKeyboard());
        onView(withId(R.id.button_create)).perform(click());
        onView(withText("Birthday Party")).check(matches(isDisplayed()));

        onView(withText("Birthday Party")).perform(click());
        onView(withId(R.id.fabAddProduct)).perform(click());
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextQuantity)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.button_Add)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextName)).perform(typeText("Cake"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextQuantity)).perform(typeText("1"),
                closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Unit"))).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withText("Cake 1 Unit")).check(matches(isDisplayed()));

        onView(withId(R.id.fabAddProduct)).perform(click());
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextQuantity)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.button_Add)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextName)).perform(typeText("Cake"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextQuantity)).perform(typeText("1"),
                closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Unit"))).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withText(R.string.Toast_message))
                .inRoot(withDecorView(not(decorView)))// Here we use decorView
                .check(matches(isDisplayed()));
    }

    @Test
    public void testEditProduct() {
        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.editTextShopListName)).check(matches(isDisplayed()));
        onView(withId(R.id.button_create)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextShopListName)).perform(typeText("Birthday Party"),
                closeSoftKeyboard());
        onView(withId(R.id.button_create)).perform(click());
        onView(withText("Birthday Party")).check(matches(isDisplayed()));

        onView(withText("Birthday Party")).perform(click());
        onView(withId(R.id.fabAddProduct)).perform(click());
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextQuantity)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.button_Add)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextName)).perform(typeText("Cake"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextQuantity)).perform(typeText("1"),
                closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Unit"))).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withText("Cake 1 Unit")).check(matches(isDisplayed()));

        onView(withText("Cake 1 Unit")).perform(click());
        onView(withId(R.id.updateUnitSpin)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextUpdateName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextUpdateQuantity)).check(matches(isDisplayed()));
        onView(withId(R.id.button_save)).check(matches(isDisplayed()));
        onView(withId(R.id.incrementButton)).check(matches(isDisplayed()));
        onView(withId(R.id.decrementButton)).check(matches(isDisplayed()));
        onView(withId(R.id.incrementButton)).perform(click());
        onView(withId(R.id.incrementButton)).perform(click());
        onView(withId(R.id.incrementButton)).perform(click());
        onView(withId(R.id.button_save)).perform(click());
        onView(withText("Cake 3 Unit")).check(matches(isDisplayed()));

    }

    @Test
    public void testDeleteProduct() {

        onView(withId(R.id.fab)).perform(click());
        onView(withId(R.id.editTextShopListName)).check(matches(isDisplayed()));
        onView(withId(R.id.button_create)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextShopListName)).perform(typeText("Birthday Party"),
                closeSoftKeyboard());
        onView(withId(R.id.button_create)).perform(click());
        onView(withText("Birthday Party")).check(matches(isDisplayed()));

        onView(withText("Birthday Party")).perform(click());
        onView(withId(R.id.fabAddProduct)).perform(click());
        onView(withId(R.id.editTextName)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextQuantity)).check(matches(isDisplayed()));
        onView(withId(R.id.spinner)).check(matches(isDisplayed()));
        onView(withId(R.id.button_Add)).check(matches(isDisplayed()));
        onView(withId(R.id.editTextName)).perform(typeText("Cake"),
                closeSoftKeyboard());
        onView(withId(R.id.editTextQuantity)).perform(typeText("1"),
                closeSoftKeyboard());
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("Unit"))).perform(click());
        onView(withId(R.id.button_Add)).perform(click());
        onView(withText("Cake 1 Unit")).check(matches(isDisplayed()));
        onView(withText("Cake 1 Unit")).perform(customswipeRight());
        onView(withText("Cake 1 Unit")).check(doesNotExist());
    }
}