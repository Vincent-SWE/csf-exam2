import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { View1Component } from './components/view1.component';
import { ReactiveFormsModule } from '@angular/forms';
import { View2Component } from './components/view2.component';
import { View0Component } from './components/view0.component';

@NgModule({
  declarations: [
    AppComponent,
    View1Component,
    View2Component,
    View0Component
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
