import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-drop-upload',
  templateUrl: './drop-upload.component.html',
  styleUrls: ['./drop-upload.component.css']
})
export class DropUploadComponent implements OnInit {

  @Output() setImage = new EventEmitter<File>()

  constructor(public fb: FormBuilder) {
    this.uploadForm = this.fb.group({
      avatar: [null],
      name: [""]
    })
  }
  uploadForm: any
  imageURL: any
  file: any

  clearImage(){
    this.file = undefined
    this.setImage.emit(this.file)
  }

  getFile(event:any){
    this.file = <File>event.target.files[0]
    this.uploadForm.patchValue({
      avatar: this.file
    })
    this.uploadForm.get('avatar').updateValueAndValidity()
    const reader = new FileReader();
    reader.onload = () => {
      this.imageURL = reader.result as string;
    }
    reader.readAsDataURL(this.file)
    this.setImage.emit(this.file)
  }
  ngOnInit(): void {
  }

}
