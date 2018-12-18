package ar.com.controlhorario.testverilook2.sdk;

public final class ExceptionUtils {

	public static String getMessage(Throwable th) {
		if (th == null) throw new NullPointerException("exception");
		String msg = null;
//		if (th instanceof AggregateExecutionException) {
//			List<Throwable> causes = ((AggregateExecutionException) th).getCauses();
//			if (causes.size() > 0) {
//				Throwable cause = causes.get(0);
//				msg = cause.getMessage() != null ? cause.getMessage() : cause.toString();
//			}
//		} else {
			msg = th.getMessage() != null ? th.getMessage() : th.toString();
//		}
		return msg;
	}

}
