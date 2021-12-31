package org.jenkinsci.plugins.sonargerrit.review.notification;

import com.google.gerrit.extensions.api.changes.NotifyHandling;
import com.google.gerrit.extensions.api.changes.ReviewInput;
import org.jenkinsci.plugins.sonargerrit.review.ReviewResultTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Project: Sonar-Gerrit Plugin Author: Tatiana Didik Created: 18.11.2017 14:57
 *
 * <p>$Id$
 */
public abstract class BaseNotificationTest extends ReviewResultTest
    implements GerritReviewNotificationTest {
  @Test
  public void testDefaultNotification() {
    ReviewInput reviewResult = getReviewResult();
    Assert.assertEquals(getDefault(), reviewResult.notify);
  }

  @Override
  @Test
  public void testNone() {
    testNotification(NotifyHandling.NONE, NotifyHandling.OWNER);
  }

  @Override
  @Test
  public void testOwner() {
    testNotification(NotifyHandling.OWNER, NotifyHandling.NONE);
  }

  @Override
  @Test
  public void testOwnerReviewers() {
    testNotification(NotifyHandling.OWNER_REVIEWERS, NotifyHandling.NONE);
  }

  @Override
  @Test
  public void testAll() {
    testNotification(NotifyHandling.ALL, NotifyHandling.NONE);
  }

  protected abstract void testNotification(NotifyHandling expected, NotifyHandling other);

  protected abstract NotifyHandling getDefault();
}
