import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import {NgxSpinnerModule} from 'ngx-spinner';
import {AgmCoreModule} from '@agm/core';

import {Overlay, OverlayContainer} from '@angular/cdk/overlay';
import {MAT_MENU_SCROLL_STRATEGY} from '@angular/material/menu';
import {CustomOverlayContainer} from './theme/utils/custom-overlay-container';
import {menuScrollStrategy} from './theme/utils/scroll-strategy';

import {environment} from 'src/environments/environment';
import {TranslateLoader, TranslateModule} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
import {SharedModule} from './shared/shared.module';
import {AppRoutingModule} from './app.routing';
import {AppComponent} from './app.component';
import {PagesComponent} from './pages/pages.component';
import {NotFoundComponent} from './pages/not-found/not-found.component';
import {TopMenuComponent} from './theme/components/top-menu/top-menu.component';
import {MenuComponent} from './theme/components/menu/menu.component';
import {SidenavMenuComponent} from './theme/components/sidenav-menu/sidenav-menu.component';
import {BreadcrumbComponent} from './theme/components/breadcrumb/breadcrumb.component';

import {AppSettings} from './app.settings';
import {AppService} from './app.service';
import {AppInterceptor} from './theme/utils/app-interceptor';
import {FooterComponent} from './theme/components/footer/footer.component';

export function HttpLoaderFactory(httpClient: HttpClient) {
    return new TranslateHttpLoader(httpClient, environment.url + '/assets/i18n/', '.json');
}


@NgModule({
    imports: [
        BrowserModule.withServerTransition({appId: 'serverApp'}),
        BrowserAnimationsModule,
        HttpClientModule,
        NgxSpinnerModule,
        AgmCoreModule.forRoot({
            apiKey: 'AIzaSyAO7Mg2Cs1qzo_3jkKkZAKY6jtwIlm41-I'
    }),
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
    SharedModule,
    AppRoutingModule
  ],
  declarations: [
    AppComponent,
    PagesComponent,
    NotFoundComponent,
    TopMenuComponent,
    MenuComponent,
    SidenavMenuComponent,
    BreadcrumbComponent,
      FooterComponent
  ], 
  providers: [
    AppSettings,
    AppService,   
    { provide: OverlayContainer, useClass: CustomOverlayContainer },
    { provide: MAT_MENU_SCROLL_STRATEGY, useFactory: menuScrollStrategy, deps: [Overlay] },
    { provide: HTTP_INTERCEPTORS, useClass: AppInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }