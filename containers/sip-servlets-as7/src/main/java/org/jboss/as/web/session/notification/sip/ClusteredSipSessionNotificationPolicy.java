/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2016, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package org.jboss.as.web.session.notification.sip;

import org.jboss.as.web.session.notification.ClusteredSessionManagementStatus;
import org.jboss.as.web.session.notification.ClusteredSessionNotificationCause;

/**
 * @author jean.deruelle@gmail.com
 * @author posfai.gergely@ext.alerant.hu
 * 
 */
public interface ClusteredSipSessionNotificationPolicy {
	/**
	 * Are invocations of <code>SipSessionListener</code> callbacks allowed
	 * under the given conditions?
	 * 
	 * @param status
	 *            the status of the session
	 * @param cause
	 *            the cause of the session notification
	 * @param local
	 *            <code>true</code> if the event driving the notification
	 *            originated on this node; <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if the notification is allowed,
	 *         <code>false</code> if not
	 */
	boolean isSipSessionListenerInvocationAllowed(
			ClusteredSessionManagementStatus status,
			ClusteredSessionNotificationCause cause, boolean local);

	/**
	 * Under the given conditions, are invocations of
	 * <code>SipSessionAttributeListener</code> callbacks allowed?
	 * 
	 * @param status
	 *            the status of the session
	 * @param cause
	 *            the cause of the session notification
	 * @param attributeName
	 *            value that would be passed to the <code>name</code> param of
	 *            the <code>SipSessionBindingEvent</code> if the listener were
	 *            invoked
	 * @param local
	 *            <code>true</code> if the event driving the notification
	 *            originated on this node; <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if the notification is allowed,
	 *         <code>false</code> if not
	 */
	boolean isSipSessionAttributeListenerInvocationAllowed(
			ClusteredSessionManagementStatus status,
			ClusteredSessionNotificationCause cause, String attributeName,
			boolean local);

	/**
	 * Under the given conditions, are invocations of
	 * <code>SipSessionBindingListener</code> callbacks allowed?
	 * 
	 * @param status
	 *            the status of the session
	 * @param cause
	 *            the cause of the session notification
	 * @param attributeName
	 *            value that would be passed to the <code>name</code> param of
	 *            the <code>SipSessionBindingEvent</code> if the listener were
	 *            invoked
	 * @param local
	 *            <code>true</code> if the event driving the notification
	 *            originated on this node; <code>false</code> otherwise
	 * 
	 * @return <code>true</code> if the notification is allowed,
	 *         <code>false</code> if not
	 */
	boolean isSipSessionBindingListenerInvocationAllowed(
			ClusteredSessionManagementStatus status,
			ClusteredSessionNotificationCause cause, String attributeName,
			boolean local);

	/**
	 * Under the given conditions, are invocations of
	 * <code>SipSessionActivationListener</code> callbacks allowed?
	 * 
	 * @param status
	 *            the status of the session
	 * @param cause
	 *            the cause of the session notification
	 * @param attributeName
	 *            value that would be passed to the <code>name</code> param of
	 *            the <code>SipSessionEvent</code> if the listener were invoked
	 * 
	 * @return <code>true</code> if the notification is allowed,
	 *         <code>false</code> if not
	 */
	boolean isSipSessionActivationListenerInvocationAllowed(
			ClusteredSessionManagementStatus status,
			ClusteredSessionNotificationCause cause, String attributeName);

	/**
	 * Provides the policy information about the container's capabilities with
	 * respect to issuing notifications. Will be invoked by the container before
	 * the first invocation of any of the other methods in this interface.
	 * 
	 * @param capability
	 *            the capability, Will not be <code>null</code>.
	 */
	void setClusteredSipSessionNotificationCapability(
			ClusteredSipSessionNotificationCapability capability);
}
