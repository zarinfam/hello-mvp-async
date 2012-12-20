package com.hellomvp.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.hellomvp.client.ClientFactory;
import com.hellomvp.client.activity.ActivityCallbackHandler;
import com.hellomvp.client.activity.GoodbyeActivity;
import com.hellomvp.client.activity.HelloActivity;
import com.hellomvp.client.place.GoodbyePlace;
import com.hellomvp.client.place.HelloPlace;

public class AppActivityMapper implements AsyncActivityMapper {

	private ClientFactory clientFactory;

	/**
	 * AppActivityMapper associates each Place with its corresponding
	 * {@link Activity}
	 * 
	 * @param clientFactory
	 *            Factory to be passed to activities
	 */
	public AppActivityMapper(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}

	@Override
	public void getActivity(final Place place,
			final ActivityCallbackHandler activityCallbackHandler) {

		if (place instanceof HelloPlace) {
			GWT.runAsync(new RunAsyncCallback() {

				public void onFailure(Throwable err) {
					Window.alert("Fail to load activity");
				}

				public void onSuccess() {
					activityCallbackHandler
							.onRecieveActivity(new HelloActivity(
									(HelloPlace) place, clientFactory));
				}
			});

		} else if (place instanceof GoodbyePlace) {
			GWT.runAsync(new RunAsyncCallback() {

				public void onFailure(Throwable err) {
					Window.alert("Fail to load activity");
				}

				public void onSuccess() {
					activityCallbackHandler
							.onRecieveActivity(new GoodbyeActivity(
									(GoodbyePlace) place, clientFactory));
				}
			});

		}else{
			activityCallbackHandler.onRecieveActivity(null);
		}
	}

}
