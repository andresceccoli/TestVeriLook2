package ar.com.controlhorario.testverilook2.sdk;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class InfoDialogFragment extends BaseDialogFragment {

	// ===========================================================
	// Private static fields
	// ===========================================================

	private static final String EXTRA_MESSAGE = "message";

	// ===========================================================
	// Public static methods
	// ===========================================================

	public static InfoDialogFragment newInstance(String message) {
		InfoDialogFragment frag = new InfoDialogFragment();
		Bundle args = new Bundle();
		args.putString(EXTRA_MESSAGE, message);
		frag.setArguments(args);
		return frag;
	}

	// ===========================================================
	// Private constructor
	// ===========================================================

	private InfoDialogFragment() {
	}

	// ===========================================================
	// Public methods
	// ===========================================================

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String message = getArguments().getString(EXTRA_MESSAGE);
		return new AlertDialog.Builder(getActivity())
			.setMessage(message)
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int whichButton) {
						dialog.cancel();
				}
		}).create();
	}

}