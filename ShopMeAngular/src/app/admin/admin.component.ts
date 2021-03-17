import { Component, OnInit } from '@angular/core';
import { ShopmeService } from '../shopme.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  imageUrl: string;
  fileToUpload: File = null;
  reader: FileReader;

  constructor(public service: ShopmeService) {
    this.imageUrl = '/assets/img/default-image.png';
   }

  ngOnInit(): void {
  }
  handleFileInput(file: FileList) {
    this.fileToUpload = file.item(0);

    // Show image preview
    this.reader = new FileReader();
    this.reader.onload = (event: any) => {
      this.imageUrl = event.target.result;
    }
    this.reader.readAsDataURL(this.fileToUpload);
  }

  OnSubmit(imageForm: any) {
   this.service.postFile(imageForm, this.fileToUpload).subscribe(
     data => {
       console.log('done');
       // Caption.value = null;
       // Image.value = null;
       this.imageUrl = '/assets/image/default.png';
     }
   );
  }

}
