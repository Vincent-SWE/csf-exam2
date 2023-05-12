import { Component } from '@angular/core';

@Component({
  selector: 'app-view0',
  templateUrl: './view0.component.html',
  styleUrls: ['./view0.component.css']
})
export class View0Component {

  archives: string[] = [];

  constructor(private archivesService: ArchivesService) {}

  ngOnInit(): void {
    this.archivesService.getBundles()
      .then(result => {
        this.bundles = result
      })
      .catch(error => {
        console.error('No results found', error)
      })
  }


}
