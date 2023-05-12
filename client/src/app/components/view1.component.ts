import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { view1Payload } from '../models';

@Component({
  selector: 'app-view1',
  templateUrl: './view1.component.html',
  styleUrls: ['./view1.component.css']
})

export class View1Component implements OnInit {
  
  view1Form!: FormGroup


  constructor(private fb: FormBuilder) { 
    this.view1Form = this.createView1Form()
  }


  ngOnInit(): void {
      this.view1Form = this.createView1Form()
  }


  createView1Form(): FormGroup {
    return this.fb.group ({
      name: this.fb.control<String>('', [Validators.required]),
      title: this.fb.control<String>('', [Validators.required]),
      comments: this.fb.control<String>(''),
      archive: [null, [Validators.required]]
    })
  }



}