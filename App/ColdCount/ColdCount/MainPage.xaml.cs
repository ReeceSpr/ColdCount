using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;


// TODO: Create Main Page.
namespace ColdCount
{
    public partial class MainPage : ContentPage
    {
        public MainPage()
        {
            InitializeComponent();
        }

        void Slider_ValueChanged(System.Object sender, Xamarin.Forms.ValueChangedEventArgs e)
        {
            if (e.NewValue == 31)
            {
                dayLabel.Text = "Quit Forever!";
            }
            else
            {
                dayLabel.Text = String.Format("{0:0} Days!", e.NewValue);

            }
        }
    }
}
