package ar.com.controlhorario.testverilook2.sdk;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;

public abstract class BaseActivity extends Activity {

    // ===========================================================
    // Private fields
    // ===========================================================

    private ProgressDialog mProgressDialog;

    // ===========================================================
    // public methods
    // ===========================================================

    public void showProgress(int messageId) {
        showProgress(getString(messageId));
    }

    public void showProgress(String message) {
        hideProgress();
        mProgressDialog = ProgressDialog.show(this, "", message);
    }

    public void hideProgress() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    public void showToast(int messageId) {
        ToastManager.show(this, messageId);
    }

    public void showToast(String message) {
        ToastManager.show(this, message);
    }

    public void showError(String message, boolean close) {
        ErrorDialogFragment.newInstance(message, close).show(getFragmentManager(), "error");
    }

    public void showError(int messageId) {
        showError(getString(messageId));
    }

    public void showError(String message) {
        showError(message, false);
    }

    public void showError(Throwable th) {
        Log.e(getClass().getSimpleName(), "Exception", th);
        showError(ExceptionUtils.getMessage(th), false);
    }

    public void showInfo(int messageId) {
        showInfo(getString(messageId));
    }

    public void showInfo(String message) {
        InfoDialogFragment.newInstance(message).show(getFragmentManager(), "info");
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgress();
    }
}
