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

package org.jboss.as.clustering.web.infinispan.sip;

import static org.jboss.logging.Logger.Level.INFO;
import static org.jboss.logging.Logger.Level.WARN;

import org.infinispan.remoting.transport.Address;
import org.jboss.logging.BasicLogger;
import org.jboss.logging.annotations.Cause;
import org.jboss.logging.annotations.LogMessage;
import org.jboss.logging.Logger;
import org.jboss.logging.annotations.Message;
import org.jboss.logging.annotations.MessageLogger;

/**
 * InfinispanSipLogger
 *
 * logging id range: 10320 - 10329
 *
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 * @author posfai.gergely@ext.alerant.hu
 */
@MessageLogger(projectCode = "JBAS")
interface InfinispanSipLogger extends BasicLogger {
    String ROOT_LOGGER_CATEGORY = InfinispanSipLogger.class.getPackage().getName();

    /**
     * A root logger with the clustering default category.
     */
    InfinispanSipLogger ROOT_LOGGER = Logger.getMessageLogger(InfinispanSipLogger.class, ROOT_LOGGER_CATEGORY);

    /**
     * Logs an informational message indicating a missing JVM route entry is being added to the sip session cache.
     */
    @LogMessage(level = INFO)
    @Message(id = 10320, value = "Adding missing jvm route entry to sip session cache")
    void addingJvmRouteEntry();

    /**
     * Logs a warning message indicating the granularity represented by the {@code deprecatedName} parameter is
     * deprecated and failing back to the granularity represented by the {@code fallbackName} parameter.
     *
     * @param deprecatedName the name of the deprecated granularity.
     * @param fallbackName   the name of the fallback granularity.
     */
    @LogMessage(level = WARN)
    @Message(id = 10321, value = "%s replication granularity is deprecated.  Falling back to %s granularity instead.")
    void deprecatedGranularity(String deprecatedName, String fallbackName);

    /**
     * Logs a warning message indicating there was a problem accessing the session.
     *
     * @param sessionId the session id.
     * @param message   the error message.
     */
    @LogMessage(level = WARN)
    @Message(id = 10322, value = "Failed to load session %s")
    void sessionLoadFailed(@Cause Throwable cause, String sessionId);

    /**
     * Logs an informational message indicating a stale JVM route entry was removed from the sip session on behalf of
     * the member.
     *
     * @param member the member.
     */
    @LogMessage(level = INFO)
    @Message(id = 10323, value = "Removed stale jvm route entry from sip session cache on behalf of member %s")
    void removedJvmRouteEntry(Address member);

    /**
     * Logs an informational message indicating a JVM entry in a sip session cache is being updated.
     *
     * @param oldRoute the old route.
     * @param newRoute the new route.
     */
    @LogMessage(level = INFO)
    @Message(id = 10324, value = "Updating jvm route entry in sip session cache.  old = %s, new = %s")
    void updatingJvmRouteEntry(String oldRoute, String newRoute);

    /**
     * Logs a warning message indicating a possible concurrency issue. The replicated version id, represented by the
     * {@code versionId} parameter, is less than or equal to the in-memory version for the session.
     *
     * @param versionId the version id.
     * @param sessionId the session id.
     */
    @LogMessage(level = WARN)
    @Message(id = 10325, value = "Possible concurrency problem: Replicated version id %d is less than or equal to in-memory version for session %s")
    void versionIdMismatch(int versionId, String sessionId);
}
