import { Component, Input, Output,EventEmitter } from '@angular/core';
// import { EventEmitter } from 'stream';

@Component({
  selector: 'app-show-error',
  imports: [],
  templateUrl: './show-error.component.html',
  styleUrl: './show-error.component.css'
})
export class ShowErrorComponent {
@Output() show=new EventEmitter<string>();
close(){
  this.show.emit("success");
}
}
