/*******************************************************************************
 * Copyright (c) 2012 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package at.bestsolution.bitbucketmgr.app;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.di.extensions.Preference;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;

import at.bestsolution.animationutils.pagetransition.ACenterSwitchAnimation;
import at.bestsolution.animationutils.pagetransition.animation.FadeAnimation;
import at.bestsolution.animationutils.pagetransition.animation.PageChangeAnimation;
import at.bestsolution.animationutils.pagetransition.animation.ZoomSlideAnimation;
import at.bestsolution.efxclipse.runtime.workbench.renderers.base.services.PerspectiveTransitionService;

@SuppressWarnings("restriction")
public class PerspectiveAnimationAddon {
	
	@PostConstruct
	void init(IEclipseContext context) {
		TransitionImpl impl = ContextInjectionFactory.make(TransitionImpl.class, context);
		context.set(PerspectiveTransitionService.class, impl);
		context.set(TransitionImpl.class, impl);
	}
	
	public static class TransitionImpl implements PerspectiveTransitionService<BorderPane, Node> {
		private Map<String, ACenterSwitchAnimation> animations = new HashMap<String, ACenterSwitchAnimation>();
		
		private String transition = "ZoomSlideAnimation";
		
		public TransitionImpl() {
			animations.put("FadeAnimation", new FadeAnimation());
			animations.put("PageChangeAnimation", new PageChangeAnimation());
			animations.put("ZoomSlideAnimation", new ZoomSlideAnimation());
		}

		public Map<String, ACenterSwitchAnimation> getAnimations() {
			return Collections.unmodifiableMap(animations);
		}
		
		@Override
		public AnimationDelegate<BorderPane, Node> getDelegate(MPerspective fromPerspective, MPerspective toPerspective) {
			if( transition != null ) {
				final String animation;
				if(  "perspective.configuration".equals(toPerspective.getElementId()) ||  "perspective.configuration".equals(fromPerspective.getElementId())) {
					animation= "FadeAnimation";
				} else {
					animation = transition;
				}
				
				return new AnimationDelegate<BorderPane, Node>() {
					@Override
					public void animate(BorderPane container, Node control) {
						animations.get(animation).animate(container, control);
					}
				};
			}
			
			return null;
		}	
	}
}
