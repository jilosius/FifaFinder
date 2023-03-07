import { Directive, ElementRef, HostListener } from "@angular/core";

//Autor: Levi
//Handles any image not found errors or when there is no image for a player
//by replacing this missing image with a placeholder image
@Directive({
  selector: "img[appHideMissing]",
})
export class HideMissingDirective {

  constructor(private el: ElementRef) {}

  @HostListener("error")
  private onError() {
    this.el.nativeElement.src = "/assets/images/imagenotfound.png"
  }

}
