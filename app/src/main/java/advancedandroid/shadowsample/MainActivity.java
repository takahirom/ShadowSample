package advancedandroid.shadowsample;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorImage();

        circleImage();

        image();
    }

    private void image() {
        final Drawable imageDrawable = getResources().getDrawable(R.mipmap.ic_launcher);
        final ShadowDrawableWrapper shadow = new ShadowDrawableWrapper(getResources(), imageDrawable, 30, 10, 20);
        shadow.setCornerRadius(10);
        final ImageView imageView = (ImageView) findViewById(R.id.image);
        imageView.setImageDrawable(shadow);
    }

    private void circleImage() {
        final OvalShape s = new OvalShape();
        final ShapeDrawable shapeDrawable = new ShapeDrawable(s);
        shapeDrawable.getPaint().setColor(Color.RED);
        final ShadowDrawableWrapper circleDrawable = new ShadowDrawableWrapper(getResources(), shapeDrawable, 30, 10, 20);
        final ImageView circleImageView = (ImageView) findViewById(R.id.circleImage);
        circleDrawable.setCornerRadius(shapeDrawable.getIntrinsicWidth());
        circleImageView.setImageDrawable(circleDrawable);
    }

    private void colorImage() {
        final ColorDrawable colorDrawable = new ColorDrawable(Color.YELLOW);
        final ShadowDrawableWrapper drawable = new ShadowDrawableWrapper(getResources(), colorDrawable, 30, 10, 20);
        final ImageView colorImageView = (ImageView) findViewById(R.id.colorImage);
        colorImageView.setImageDrawable(drawable);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
