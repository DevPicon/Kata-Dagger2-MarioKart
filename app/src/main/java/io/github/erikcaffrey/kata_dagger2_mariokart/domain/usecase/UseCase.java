package io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

@SuppressWarnings("unchecked") abstract class UseCase {

  private Subscription subscription = Subscriptions.empty();

  UseCase() {
  }

  public void execute(Subscriber UseCaseSubscriber) {
    this.subscription = this.buildObservableUseCase().subscribe(UseCaseSubscriber);
  }

  public void unsubscribe() {
    if (!subscription.isUnsubscribed()) {
      subscription.unsubscribe();
    }
  }

  protected abstract Observable buildObservableUseCase();
}