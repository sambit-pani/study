import { Directive, ElementRef, HostListener, Input, HostBinding } from '@angular/core';

@Directive({
  selector: '[appHighlight]'
})
export class HighlightDirective {

  @Input('appHighlight') color:string = 'yellow';

  @HostBinding('style.backgroundcolor') colorStyle:string;
  constructor(private elementRef:ElementRef) {
      
   }

   @HostListener("mouseenter") addHighlighter(){
    this.colorStyle = 'red';
   }

   @HostListener("mouseleave") removeHighlighter(){
    this.elementRef.nativeElement.style.backgroundColor= null;
   }
}
